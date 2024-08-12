class KthLargest {
    int k;
    List<Integer> nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
    }
    
    public int add(int val) {
        int idx = 0;
        while(idx<nums.size() && nums.get(idx)<val)
            idx++;
        nums.add(idx, val);
        // System.out.println(nums);
        return nums.get(nums.size() - k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */