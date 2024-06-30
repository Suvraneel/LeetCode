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
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(isConnected[i][j]==1)
                    uf.union(i, j);
        Set<Integer> roots = new HashSet<>();
        for(int i=0; i<n; i++)
            roots.add(uf.find(i));
        return roots.size();
    }
}