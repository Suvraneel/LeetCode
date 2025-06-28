class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Queue<int[]> pq1 = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Queue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < nums.length; i++)
            pq1.offer(new int[] { nums[i], i });
        for (int i = 0; i < k; i++)
            pq2.offer(pq1.poll());
        int[] ans = new int[k];
        int i = 0;
        while (!pq2.isEmpty())
            ans[i++] = pq2.poll()[0];
        return ans;
    }
}