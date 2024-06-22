class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, lt = 0, rt = 0, ct = 0, ans = 0;
        while (rt < n) {
            while (rt < n && ct < k) {
                if (nums[rt] % 2 == 1)
                    ct++;
                rt++;
            }
            if (ct != k)
                break;
            int ltFlank = 0, rtFlank = 0;
            while (lt < n && nums[lt] % 2 == 0) {
                ltFlank++;
                lt++;
            }
            while (rt < n && nums[rt] % 2 == 0) {
                rtFlank++;
                rt++;
            }
            ans += (ltFlank + 1) * (rtFlank + 1);
            lt++;
            ct--;
        }
        return ans;
    }
}