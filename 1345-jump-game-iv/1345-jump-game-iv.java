class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length, ans = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        boolean[] vis = new boolean[n];
        Queue<Integer> level = new LinkedList<>(Arrays.asList(0));
        while (!level.isEmpty()) {
            int size = level.size();
            while (size-- > 0) {
                int node = level.poll();
                if (node == n - 1)
                    return ans;
                // Check same valued jumps
                for (int nbr : graph.get(arr[node])) {
                    if (!vis[nbr]) {
                        level.offer(nbr);
                        vis[nbr] = true;
                    }
                }
                graph.get(arr[node]).clear();
                // Check adjacent jumps
                if (0 < node && !vis[node - 1]) {
                    level.offer(node - 1);
                    vis[node - 1] = true;
                }
                if (node < n - 1 && !vis[node + 1]) {
                    level.offer(node + 1);
                    vis[node + 1] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}