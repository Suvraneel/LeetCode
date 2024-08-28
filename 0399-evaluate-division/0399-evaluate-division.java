class Solution {
    record Pair(String num, String den) {
    }

    Map<Pair, Double> memo = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> eqn = equations.get(i);
            adj.putIfAbsent(eqn.get(0), new HashMap<>());
            adj.putIfAbsent(eqn.get(1), new HashMap<>());
            adj.get(eqn.get(0)).put(eqn.get(1), values[i]);
            adj.get(eqn.get(1)).put(eqn.get(0), 1/values[i]);
        }
        // System.out.println(adj);
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String src = q.get(0), dest = q.get(1);
            if (!adj.containsKey(src))
                ans[i] = -1d;
            else if (memo.containsKey(new Pair(src, dest)))
                ans[i] = memo.get(new Pair(src, dest));
            else {
                dfs(adj, new HashSet<>(), src, src, dest, 1d);
                ans[i] = memo.getOrDefault(new Pair(src, dest), -1d);
            }
        }
        return ans;
    }

    private void dfs(Map<String, Map<String, Double>> adj, Set<String> vis, String src, String curr, String dest,
            double prob) {
        vis.add(curr);
        memo.put(new Pair(src, curr), prob);
        memo.put(new Pair(curr, src), 1/prob);
        if (curr.equals(dest))
            return;
        for (Map.Entry<String, Double> nbr : adj.get(curr).entrySet())
            if (!vis.contains(nbr.getKey()))
                dfs(adj, vis, src, nbr.getKey(), dest, prob * nbr.getValue());
    }
}