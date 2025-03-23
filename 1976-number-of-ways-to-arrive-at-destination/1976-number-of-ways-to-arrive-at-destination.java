class Solution {
    private record Node(int dest, long delay) {
    };

    public int countPaths(int n, int[][] roads) {
        long[] minDelay = new long[n];
        int[] pathCount = new int[n];
        long INF = Long.MAX_VALUE;
        int MOD = 1_000_000_007;
        Arrays.fill(minDelay, INF);
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] r : roads) {
            adj[r[0]].add(new int[] { r[1], r[2] });
            adj[r[1]].add(new int[] { r[0], r[2] });
        }
        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        int timeElapsed = 0;
        minDelay[0] = 0;
        pathCount[0] = 1;
        pq.offer(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            if (node[1] > minDelay[(int) node[0]])
                continue;
            for (int[] nbr : adj[(int) node[0]]) {
                long potentialDelay = node[1] + nbr[1];
                if (potentialDelay < minDelay[nbr[0]]) {
                    minDelay[nbr[0]] = potentialDelay;
                    pathCount[nbr[0]] = pathCount[(int) node[0]];
                    pq.offer(new long[] { nbr[0], potentialDelay });
                } else if (potentialDelay == minDelay[nbr[0]]) {
                    pathCount[nbr[0]] += pathCount[(int) node[0]];
                    pathCount[nbr[0]] %= MOD;
                }
            }
        }
        return pathCount[n - 1];
    }
}