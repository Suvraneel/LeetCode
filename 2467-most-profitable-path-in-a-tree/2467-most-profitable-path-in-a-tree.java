class Solution {
    int maxProfit = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        List<Integer>[] adj = new List[n];
        boolean[] visA = new boolean[n], visB = new boolean[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        dfs(adj, amount, visA, visB, 0, bob, 0);
        return maxProfit;
    }

    private void dfs(List<Integer>[] adj, int[] amount, boolean[] visA, boolean[] visB, int a, int b, int profit) {
        System.out.println(Arrays.toString(amount) + profit);
        profit += a == b ? amount[a] / 2 : amount[a];
        if (a != 0 && adj[a].size() == 1) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }
        int amtA = amount[a], amtB = amount[b];
        amount[a] = 0;
        amount[b] = 0;
        for (int nbrA : adj[a]) {
            if (visA[nbrA])
                continue;
            visA[nbrA] = true;
            if (b == 0) {
                dfs(adj, amount, visA, visB, nbrA, 0, profit);
            } else {
                for (int nbrB : adj[b]) {
                    if (visB[nbrB])
                        continue;
                    visB[nbrB] = true;
                    dfs(adj, amount, visA, visB, nbrA, nbrB, profit);
                }
            }
        }
        amount[a] = amtA;
        amount[b] = amtB;
    }
}