class Solution {
    private int largestSubgraphSize = 1;

    private class UnionFind {
        int[] root;
        int[] rank;
        int[] subgraphSize;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            subgraphSize = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
                subgraphSize[i] = 1;
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
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                    subgraphSize[rootX] += subgraphSize[rootY];
                    largestSubgraphSize = Math.max(largestSubgraphSize, subgraphSize[rootX]);
                } else if (rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                    subgraphSize[rootY] += subgraphSize[rootX];
                    largestSubgraphSize = Math.max(largestSubgraphSize, subgraphSize[rootY]);
                } else {
                    root[rootX] = rootY;
                    rank[rootY]++;
                    subgraphSize[rootY] += subgraphSize[rootX];
                    largestSubgraphSize = Math.max(largestSubgraphSize, subgraphSize[rootY]);
                }
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        int getSubgraphSize(int x) {
            return subgraphSize[find(x)];
        }
    }

    private int getId(int i, int j, int n) {
        return i * n + j;
    }

    private boolean isValid(int i, int j, int n) {
        return Math.min(i, j) >= 0 && Math.max(i, j) < n;
    }

    private static int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cell_id = getId(i, j, n);
                    for (int[] d : dirs) {
                        int I = i + d[0], J = j + d[1];
                        if (isValid(I, J, n) && grid[I][J] == 1)
                            uf.union(cell_id, getId(I, J, n));
                    }
                }
            }
        }
        System.out.println(largestSubgraphSize);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int largestPotentialSubgraphSize = 1;
                    Set<Integer> subgraphsCounted = new HashSet<>();
                    for (int[] d : dirs) {
                        int I = i + d[0], J = j + d[1], nbr_id = getId(I, J, n);
                        if (isValid(I, J, n) && grid[I][J] == 1
                                && !subgraphsCounted.contains(uf.find(nbr_id))) {
                            largestPotentialSubgraphSize += uf.getSubgraphSize(nbr_id);
                            subgraphsCounted.add(uf.find(nbr_id));
                        }
                    }
                    largestSubgraphSize = Math.max(largestSubgraphSize, largestPotentialSubgraphSize);
                }
            }
        }
        return largestSubgraphSize;
    }
}