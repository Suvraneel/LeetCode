class Solution {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private boolean isValid(int m, int n, int i, int j, boolean[][] vis){
        return i>=0 && j>=0 && i<m && j<n && !vis[i][j];
    }
    // private UnionFind {
    //     int[] root;
    //     int[] size;
        
    //     UnionFind(int n){
    //         root = new int[n];
    //         size = new int[n];
    //         for(int i=0; i<n; i++){
    //             root[i] = i;
    //             size[i] = 1;
    //         }
    //     }

    //     int find(int node){
    //         if(node = root[node])
    //             return node;
    //         return find(root[node]);
    //     }

    //     int union(int x, int y){
    //         int rootX = find(x);
    //         int rootY = find(y);
    //         if (rootX != rootY){
    //             if (size[rootX] > size[rootY]){
    //                 root[rootY] = rootX;
    //                 size[rootX] += size[rootY];
    //             } else {
    //                 root[rootX] = rootY;
    //                 size[rootY] += size[rootX];
    //             }
    //         }
    //     }
    // }

    public int[] maxPoints(int[][] grid, int[] queries) {
        Queue<int[]> bfs = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        TreeMap<Integer, Integer> bst = new TreeMap<>();
        int m = grid.length, n = grid[0].length, q = queries.length, count = 0, maxSeen = 0;
        boolean[][] vis = new boolean[m][n];
        bfs.offer(new int[]{0, 0, grid[0][0]});
        bst.put(0, 0);
        while(!bfs.isEmpty()){
            int[] top = bfs.poll();
            if(vis[top[0]][top[1]])
                continue;
            vis[top[0]][top[1]] = true;
            maxSeen = Math.max(maxSeen, top[2]);
            bst.put(maxSeen+1, ++count);
            for(int[] d: dirs){
                int I = top[0] + d[0], J = top[1] + d[1];
                if(isValid(m, n, I, J, vis))
                    bfs.offer(new int[]{I, J, grid[I][J]});
            }
            // System.out.println(bst + "\t" + grid[top[0]][top[1]]);
        }
        int[] answer = new int[q];
        for(int i=0; i<q; i++)
            answer[i] = bst.get(bst.containsKey(queries[i]) ? queries[i] : bst.lowerKey(queries[i]));
        return answer;
    }
}