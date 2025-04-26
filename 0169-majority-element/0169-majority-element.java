class Solution {
    public int majorityElement(int[] nums) {
        int ct = 0, candidate = -1;
        for (int e : nums) {
            if (ct == 0) {
                candidate = e;
                ct = 1;
            } else ct += candidate == e ? 1 : -1;
        }
        return candidate;
    }
}
