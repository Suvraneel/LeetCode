class Solution {
    private int[] topoSort(int[][] edges, int n) {  // Kahn's algo
        List<Integer>[] adj = new ArrayList[n+1];
        int[] indegree = new int[n+1], order = new int[n];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges){
            adj[e[0]].add(e[1]);
            indegree[e[1]]++;    
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++)
            if(indegree[i]==0)
                q.offer(i);
        int idx = 0;
        while(!q.isEmpty()){
            int V = q.poll();
            order[idx++] = V;
            n--;
            for(int nbr: adj[V]){
                if(--indegree[nbr]==0)
                    q.offer(nbr);
            }
        }
        if(n>0) // ain't a DAG
            return new int[0];
        return order;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        int[] rowOrder = topoSort(rowConditions, k);
        int[] colOrder = topoSort(colConditions, k);
        if (rowOrder.length == 0 || colOrder.length == 0) // Either is !DAG
            return new int[0][0]; // matrix generation infeasible
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                if (rowOrder[i]==colOrder[j])
                    matrix[i][j] = rowOrder[i];
        return matrix;
    }
}