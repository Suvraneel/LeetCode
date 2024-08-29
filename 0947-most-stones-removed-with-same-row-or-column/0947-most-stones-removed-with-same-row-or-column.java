class Solution {
    private class UnionFind {
        int setCount;
        int[] root;
        int[] rank;

        UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            this.setCount = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY])
                    root[rootY] = rootX;
                else if (rank[rootX] < rank[rootY])
                    root[rootX] = rootY;
                else {
                    root[rootX] = rootY;
                    rank[rootY]++;
                }
                this.setCount--;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    private int getId(int r, int c, int m, int n) {
        return r * n + c;
    }

    private int getId(int[] coord, int m, int n) {
        return coord[0] * n + coord[1];
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    uf.union(i, j);
        return n - uf.setCount;
    }
}