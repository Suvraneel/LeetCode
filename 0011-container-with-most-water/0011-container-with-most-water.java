class Solution {
    public int maxArea(int[] height) {
        int lt = 0, rt = height.length - 1, maxArea = Math.min(height[lt], height[rt]) * (rt - lt);
        while (lt < rt) {
            if (height[lt] <= height[rt])
                while (height[lt] > height[++lt] && lt < rt);
            else
                while (height[rt] > height[--rt] && lt < rt);
            maxArea = Math.max(maxArea, Math.min(height[lt], height[rt]) * (rt - lt));
        }
        return maxArea;
    }
}