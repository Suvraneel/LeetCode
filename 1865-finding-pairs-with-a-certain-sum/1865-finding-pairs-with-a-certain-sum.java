class FindSumPairs {
    Map<Integer, Integer> nums1Freq = new TreeMap<>();
    Map<Integer, Integer> nums2Freq = new HashMap<>();
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        for (int i : nums1)
            nums1Freq.put(i, nums1Freq.getOrDefault(i, 0) + 1);
        for (int i : nums2)
            nums2Freq.put(i, nums2Freq.getOrDefault(i, 0) + 1);
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        nums2Freq.put(nums2[index], nums2Freq.get(nums2[index]) - 1);
        if (nums2Freq.get(nums2[index]) == 0)
            nums2Freq.remove(nums2[index]);
        nums2[index] += val;
        nums2Freq.put(nums2[index], nums2Freq.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ct = 0;
        for (Map.Entry<Integer, Integer> e : nums1Freq.entrySet()) {
            if (e.getKey() > tot)
                break;
            ct += nums2Freq.getOrDefault(tot - e.getKey(), 0) * e.getValue();
        }
        return ct;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */