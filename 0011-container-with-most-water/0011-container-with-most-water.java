class Solution {
    public int maxArea(int[] height) {
        int lt = 0, rt = height.length - 1, ans = 0;
        while (lt < rt) {
            if (height[lt] < height[rt])
                ans = Math.max(ans, (rt - lt) * height[lt++]);
            else
                ans = Math.max(ans, (rt - lt) * height[rt--]);
        }
        return ans;
    }
}