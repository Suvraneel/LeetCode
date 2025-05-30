class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = bfs(edges, node1);
        int[] dist2 = bfs(edges, node2);
        int n = edges.length, minMaxDist = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            int maxDistToTarget = Math.max(dist1[i], dist2[i]);
            if (minMaxDist > maxDistToTarget) {
                minMaxDist = maxDistToTarget;
                ans = i;
            }
        }
        return ans;
    }

    private int[] bfs(int[] edges, int src) {
        int n = edges.length, INF = Integer.MAX_VALUE, hops = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        while (src != -1 && dist[src] == INF) {
            dist[src] = hops++;
            src = edges[src];
        }
        return dist;
    }
}