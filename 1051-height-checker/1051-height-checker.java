class Solution {
    public int heightChecker(int[] heights) {
        int ans = 0, n = heights.length;
        int[] expected = new int[n];
        expected = Arrays.copyOf(heights, n);
        Arrays.sort(expected);
        while (--n >= 0)
            if (expected[n] != heights[n])
                ans++;
        return ans;
    }
}