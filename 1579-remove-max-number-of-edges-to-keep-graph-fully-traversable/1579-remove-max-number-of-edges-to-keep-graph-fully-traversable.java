class Solution {
    int edgeCount = 0;

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
            // if (rootU == rootV)
            // return;
            if (rank[rootU] > rank[rootV])
                root[rootV] = rootU;
            else if (rank[rootU] < rank[rootV])
                root[rootU] = rootV;
            else {
                root[rootV] = rootU;
                rank[rootU] += 1;
            }
            edgeCount++;
        }

        public boolean connected(int u, int v) {
            return find(u) == find(v);
        }

        public UnionFind clone(UnionFind ufNew) {
            ufNew.root = this.root.clone();
            ufNew.rank = this.rank.clone();
            return ufNew;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n + 1);
        for (int[] e : edges) {
            if (e[0] == 3 && !uf.connected(e[1], e[2]))
                uf.union(e[1], e[2]);
        }
        UnionFind ufAlice = new UnionFind(n + 1);
        ufAlice = uf.clone(ufAlice);
        UnionFind ufBob = uf;
        for (int[] e : edges) {
            if (e[0] == 1 && !ufAlice.connected(e[1], e[2]))
                ufAlice.union(e[1], e[2]);
            else if (e[0] == 2 && !ufBob.connected(e[1], e[2]))
                ufBob.union(e[1], e[2]);
        }
        int head = uf.find(1);
        for (int i = 1; i <= n; i++)
            if (ufAlice.find(i) != head || ufBob.find(i) != head)
                return -1;
        return edges.length - edgeCount;
    }
}