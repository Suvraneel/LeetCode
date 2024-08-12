class KthLargest {
    int k;
    List<Integer> nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
    }

    public int add(int val) {
        int idx = 0;
        nums.add(binarySearch(val), val);
        // System.out.println(nums);
        return nums.get(nums.size() - k);
    }

    private int binarySearch(int val) {
        int lt = 0, rt = nums.size() - 1;
        while (lt <= rt) {
            int mid = lt + (rt - lt / 2);
            if (nums.get(mid) < val)
                lt = mid + 1;
            else
                rt = mid - 1;
        }
        return lt;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */