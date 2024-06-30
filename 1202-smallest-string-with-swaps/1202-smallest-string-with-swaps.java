class Solution {
    private class UnionFind {
        public int[] root;
        public int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (root[node] != node)
                return root[node] = find(root[node]);
            return node;
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV)
            return;
            if (rank[rootU] > rank[rootV])
                root[rootV] = rootU;
            else if (rank[rootU] < rank[rootV])
                root[rootU] = rootV;
            else {
                root[rootV] = rootU;
                rank[rootU] += 1;
            }
        }

        public boolean connected(int u, int v) {
            return find(u) == find(v);
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] S = s.toCharArray();
        UnionFind uf = new UnionFind(n);
        for(List<Integer> edge: pairs)
            uf.union(edge.get(0), edge.get(1));
        Map<Integer, Queue<Character>> connectedSwaps = new HashMap<>();
        for(int i=0; i<n; i++){
            Queue<Character> q = connectedSwaps.getOrDefault(uf.find(i), new PriorityQueue<>());
            q.add(S[i]);
            connectedSwaps.put(uf.find(i), q);
        }
        String ans = "";
        for(int i=0; i<n; i++)
            ans += connectedSwaps.get(uf.find(i)).poll();
        return ans;
    }
}