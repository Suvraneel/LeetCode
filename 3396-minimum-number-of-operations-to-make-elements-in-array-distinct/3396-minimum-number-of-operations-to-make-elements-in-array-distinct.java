class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> prevOcc = new HashMap<>();
        int n = nums.length, lt = 0;
        for (int i = 0; i < n; i++) {
            if (prevOcc.containsKey(nums[i]))
                lt = Math.max(lt, prevOcc.get(nums[i]) + 1);
            prevOcc.put(nums[i], i);
        }
        return (int) Math.ceil(lt / 3.0);
    }
}