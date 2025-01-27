class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Set<Integer>[] adj = new Set[numCourses];
        boolean[] vis = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new HashSet<>();
        for (int[] p : prerequisites)
            adj[p[1]].add(p[0]);
        for (int i = 0; i < numCourses; i++)
            dfs(adj, i, vis);
        System.out.println(Arrays.toString(adj));
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries)
            ans.add(adj[q[1]].contains(q[0]));
        return ans;
    }

    private Set<Integer> dfs(Set<Integer>[] adj, int i, boolean[] vis) {
        if (vis[i])
            return adj[i];
        vis[i] = true;
        Set<Integer> finalPreReqList = new HashSet<>(adj[i]);
        for (int preReq : adj[i])
            finalPreReqList.addAll(dfs(adj, preReq, vis));
        return adj[i] = finalPreReqList;
    }
}