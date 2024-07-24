class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mappedNums = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] k = String.valueOf(nums[i]).toCharArray();
            StringBuilder mappedK = new StringBuilder();
            for (char c : k)
                mappedK.append(mapping[c - '0']);
            mappedNums.put(nums[i], Integer.parseInt(mappedK.toString()));
        }
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> mappedNums.get(a) - mappedNums.get(b)).mapToInt(Integer::intValue).toArray();
        return nums;
    }
}