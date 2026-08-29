class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int prev = -limit, idx = -1;
        List<Queue<Integer>> grps = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - prev > limit) {
                idx++;
                grps.add(new LinkedList<>());
            }
            grps.get(idx).add(arr[i]);
            map.put(arr[i], idx);
            prev = arr[i];
        }
        // System.out.println(map);
        // System.out.println(grps);
        for (int i = 0; i < nums.length; i++)
            nums[i] = grps.get(map.get(nums[i])).poll();
        return nums;
    }
}