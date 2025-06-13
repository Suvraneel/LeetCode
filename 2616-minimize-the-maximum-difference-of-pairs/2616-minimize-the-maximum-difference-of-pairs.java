class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 1; i < n; i++)
            pq.offer(new int[] { Math.abs(nums[i - 1] - nums[i]), i });
        while (p > 0) {
            int[] top = pq.poll();
            if (vis[top[1]] || vis[top[1] - 1])
                continue;
            vis[top[1]] = true;
            vis[top[1] - 1] = true;
            ans = Math.max(ans, top[0]);
            p--;
        }
        return ans;
    }
}