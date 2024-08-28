class Solution {
    private class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (root[x] == x)
                return x;
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = root[x];
            int rootY = root[y];
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    // Helper to encode node T into unique id for UnionFind DS
    private int getId(int i, int j, int n) {
        return i * n + j;
    }

    private static final int[][] directions = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    private boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }

    private void joinLand(int i, int j, int m, int n, int[][] grid, UnionFind uf) {
        for (int[] dir : directions) {
            int r = i + dir[0], c = j + dir[1];
            if (isValid(r, c, m, n) && grid[r][c] == 1)
                uf.union(getId(i, j, n), getId(r, c, n));
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, size = m * n;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1)
                    joinLand(i, j, m, n, grid2, uf);
            }
        }
        boolean[] isNotSubIsland = new boolean[size];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid1[i][j] != 1 && grid2[i][j] == 1)
                    isNotSubIsland[uf.find(getId(i, j, n))] = true;
        int subIslandsCt = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid2[i][j] == 1 && !isNotSubIsland[uf.find(getId(i, j, n))]){
                    subIslandsCt++;
                    isNotSubIsland[uf.find(getId(i, j, n))] = true;
                }
        return subIslandsCt;
    }
}