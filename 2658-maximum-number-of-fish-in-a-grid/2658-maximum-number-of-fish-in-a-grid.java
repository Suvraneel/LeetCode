class Solution {
    private class UnionFind {
        int[] root;
        int[] rank;
        int[] totalFish;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            totalFish = new int[size];
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
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                    totalFish[rootY] += totalFish[rootX];
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                    totalFish[rootX] += totalFish[rootY];
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                    totalFish[rootX] += totalFish[rootY];
                }
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        // void printRoots() {
        //     System.out.println(Arrays.toString(root));
        // }
    }

    int getID(int i, int j, int m, int n) {
        return i * n + j;
    }

    boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxFish = 0;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                uf.totalFish[getID(i, j, m, n)] = grid[i][j]; // Initialize self-root fish count
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int cell_id = getID(i, j, m, n);
                    for (int[] d : dirs) {
                        int I = i + d[0], J = j + d[1];
                        if (isValid(I, J, m, n) && grid[I][J] > 0)
                            uf.union(cell_id, getID(I, J, m, n));
                    }
                }
            }
        }
        for (int i = 0; i < m * n; i++) {
            maxFish = Math.max(maxFish, uf.totalFish[i]);
        }
        // uf.printRoots();
        // System.out.println(fishCount);
        return maxFish;
    }
}