class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        Map<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            degree.put(edges[i][0], degree.getOrDefault(edges[i][0], 0) + 1);
            degree.put(edges[i][1], degree.getOrDefault(edges[i][1], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : degree.entrySet())
            if (e.getValue() == n)
                return e.getKey();
        return -1;
    }
}