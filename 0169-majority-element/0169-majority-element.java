class Solution {
    public int majorityElement(int[] nums) {
        int major = -1, freq = 0;
        for (int i : nums) {
            if (major == i)
                freq++;
            else {
                freq--;
                if (freq < 0) {
                    freq = 0;
                    major = i;
                }
            }
        }
        return major;
    }
}