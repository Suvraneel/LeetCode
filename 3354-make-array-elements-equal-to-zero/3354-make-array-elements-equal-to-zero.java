class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length, prefixSum = 0, totalSum = 0, count = 0;
        for (int i : nums)
            totalSum += i;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int postfixSum = totalSum - prefixSum;
                if (postfixSum == prefixSum)
                    count += 2;
                else if (Math.abs(postfixSum - prefixSum) == 1)
                    count++;
            } else
                prefixSum += nums[i];
        }
        return count;
    }
}