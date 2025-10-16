class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] freq = new int[Math.max(n, value)];
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                freq[nums[i] % value]++;
            else
                freq[(value - (Math.abs(nums[i]) % value)) % value]++;
        // System.out.println(Arrays.toString(freq));
        for (int i = 0; i < nums.length; i++) {
            if (freq[i % value] >= 1) {
                freq[i % value]--; // carry over 1 entry from mod bucket
                // freq[i] = 1;     // not necessary for calc., leaving here for intuition
            } else
                return i;
        }
        return n;
    }
}