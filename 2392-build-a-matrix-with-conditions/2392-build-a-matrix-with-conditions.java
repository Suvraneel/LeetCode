class Solution {
    private void dfs(List<List<Integer>> adj, int[] vis, int V, List<Integer> order, boolean[] hasCycle) {
        vis[V] = 1;
        for (int nbr : adj.get(V)) {
            if (vis[nbr] == 0) {
                dfs(adj, vis, nbr, order, hasCycle);
                if (hasCycle[0])
                    return;
            } else if (vis[nbr] == 1) {
                hasCycle[0] = true;
                return;
            }
        }
        vis[V] = 2;
        order.add(V);
    }

    private List<Integer> topoSort(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges)
            adj.get(e[0]).add(e[1]);
        int[] vis = new int[n + 1];
        boolean[] hasCycle = { false };
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (vis[i] == 0) {
                dfs(adj, vis, i, order, hasCycle);
                if (hasCycle[0])
                    return new ArrayList<>(); // Not a DAG
            }
        }
        Collections.reverse(order);
        return order;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> rowOrder = topoSort(rowConditions, k);
        List<Integer> colOrder = topoSort(colConditions, k);
        if (rowOrder.isEmpty() || colOrder.isEmpty()) // Either !DAG
            return new int[0][0]; // matrix generation infeasible
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                if (rowOrder.get(i) == colOrder.get(j))
                    matrix[i][j] = rowOrder.get(i);
        return matrix;
    }
}