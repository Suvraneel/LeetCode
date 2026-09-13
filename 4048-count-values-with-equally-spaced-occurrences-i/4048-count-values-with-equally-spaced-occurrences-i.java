class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] freq = new int[101];
        int[] last = new int[101];
        int[] spacing = new int[101];
        boolean[] impossible = new boolean[101];
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] >= 3)
                impossible[nums[i]] = true;
            if (freq[nums[i]] >= 2 && spacing[nums[i]] != i - last[nums[i]])
                impossible[nums[i]] = true;
            freq[nums[i]]++;
            spacing[nums[i]] = i - last[nums[i]];
            last[nums[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i <= 100; i++)
            if (freq[i] == 3 && !impossible[i])
                ans++;
        return ans;
    }
}