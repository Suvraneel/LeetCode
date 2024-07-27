class Solution {
    public long minimumCost(String source, String target,
            char[] original, char[] changed, int[] cost) {
        List<int[]>[] adj = new List[26];
        for (int i = 0; i < 26; i++)
            adj[i] = new ArrayList<>();
        int n = original.length, m = source.length();
        for (int i = 0; i < n; i++)
            adj[original[i] - 'a'].add(new int[] { changed[i] - 'a', cost[i] });
        // Run Djikstra for all pair shortest path (not the best algo, Ikr)
        int minCosts[][] = new int[26][26];
        for (int i = 0; i < 26; i++)
            minCosts[i] = djikstra(i, adj);
        char[] src = source.toCharArray(), tgt = target.toCharArray();
        long ans = 0;
        for (int i = 0; i < m; i++) {
            long minCost = minCosts[src[i] - 'a'][tgt[i] - 'a'];
            // System.out.println(src[i]+"->"+tgt[i]+"="+minCost);
            if (minCost == Integer.MAX_VALUE)
                return -1;
            ans += minCost;
        }
        return ans;
    }

    private int[] djikstra(int start, List<int[]>[] adj) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { start, 0 });
        int minCost[] = new int[26];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[start] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currChar = top[0], currCost = top[1];
            if (currCost > minCost[currChar])
                continue;
            for (int[] nbr : adj[currChar]) {
                int nbrChar = nbr[0], nbrEdge = nbr[1];
                if (minCost[nbrChar] > currCost + nbrEdge) {
                    minCost[nbrChar] = currCost + nbrEdge;
                    pq.offer(new int[] { nbrChar, minCost[nbrChar] });
                }
            }
        }
        return minCost;
    }
}