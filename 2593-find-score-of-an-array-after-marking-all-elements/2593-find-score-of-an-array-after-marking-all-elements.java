class Solution {
    public long findScore(int[] nums) {
        List<int[]> l = new ArrayList<>();
        int n = nums.length;
        long score = 0;
        for (int i = 0; i < n; i++)
            l.add(new int[] { nums[i], i });
        // l.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        l.sort((a, b) -> a[0] - b[0]); // Stable sort, so not reqd. ^
        for (int i = 0; i < n; i++) {
            int[] top = l.get(i);
            if (nums[top[1]] == 0)
                continue;
            score += top[0];
            nums[top[1]] = 0;
            if (top[1] > 0)
                nums[top[1] - 1] = 0;
            if (top[1] < n - 1)
                nums[top[1] + 1] = 0;
        }
        return score;
    }
}