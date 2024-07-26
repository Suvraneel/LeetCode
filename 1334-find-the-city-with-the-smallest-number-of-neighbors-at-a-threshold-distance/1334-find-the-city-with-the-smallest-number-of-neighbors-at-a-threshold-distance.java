class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];
        List<int[]>[] adj = new List[n];    // [] of LL of int{nbr, wt}
        for(int i=0; i<n; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);    // INF
            cost[i][i] = 0; // self wt.
            adj[i] = new ArrayList<>(); // init LL
        }
        for(int[] e: edges){ // populate edges in adjList
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }
        for(int src=0; src<n; src++)    // djikstra on each node as source
            djikstra(n, adj, cost[src], src);
        int ans = -1, minCt = n;
        for(int i=0; i<n; i++){
            int currCt = 0;
            for(int j=0; j<n; j++)
                if(cost[i][j]<=distanceThreshold)
                    currCt++;
            if(minCt>=currCt){
                minCt = currCt;
                ans = i;
            }
        }
        return ans;
    }
    void djikstra(int n, List<int[]>[] adj, int[] cost, int src){
        Queue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.add(new int[]{src, 0});
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int currCity = node[0], currCost = node[1];
            if(currCost>cost[currCity]) // worse path, skip
                continue;
            for(int[] nbr: adj[currCity]){
                int nbrCity = nbr[0], nbrEdge = nbr[1];
                int newCostNbr = currCost+nbrEdge;
                if(cost[nbrCity]>newCostNbr){
                    cost[nbrCity] = newCostNbr;
                    pq.add(new int[]{nbrCity, newCostNbr});
                }
            }
        }
    }
}