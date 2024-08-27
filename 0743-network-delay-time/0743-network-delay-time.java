class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new List[n+1];
        Set<Integer> vis = new HashSet<>();
        for(int i=1; i<=n; i++)
            adj[i] = new ArrayList<>();
        for(int[] edge: times)
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        int maxDelay = Integer.MAX_VALUE;
        return djikstra(adj, k, vis, n);
    }

    private int djikstra(List<int[]>[] adj, int src, Set<Integer> vis, int n){
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));
        pq.offer(new int[]{src, 0});
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            if(vis.contains(top[0]))
                continue;
            vis.add(top[0]);
            if(vis.size()==n)
                return top[1];
            for(int[] nbr: adj[top[0]])
                pq.offer(new int[]{nbr[0], top[1]+nbr[1]});
        }
        return -1;
    }
}