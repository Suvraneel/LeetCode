class Solution {
    public long findScore(int[] nums) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int n = nums.length;
        long score = 0;
        for (int i = 0; i < n; i++)
            pq.offer(new int[] { nums[i], i });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
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