class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums)
            xor ^= n;
        int diff = xor & -xor; // find set bit for masking

        int ans1 = 0;
        for (int n : nums)
            if ((n & diff) == 0)
                ans1 ^= n;

        return new int[] { ans1, ans1 ^ xor };
    }
}