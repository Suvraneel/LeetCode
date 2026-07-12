class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return new int[0];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length; i++)
            pq.offer(new int[] { arr[i], i });
        int idx = 0, prev = pq.peek()[0] - 1;
        int[] ans = new int[arr.length];
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (prev == top[0])
                ans[top[1]] = idx;
            else {
                ans[top[1]] = ++idx;
                prev = top[0];
            }
        }
        return ans;
    }
}