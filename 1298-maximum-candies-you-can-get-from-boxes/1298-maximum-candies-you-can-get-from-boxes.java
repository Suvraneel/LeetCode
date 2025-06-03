class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length, candyCt = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> closed = new HashSet<>();
        for (int b : initialBoxes)
            bfs.add(b);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            while (size-- > 0) {
                int top = bfs.poll();
                if (status[top] == 0) {// locked
                    closed.add(top);
                    continue;
                }
                if (vis[top]) // looted already
                    continue;
                candyCt += candies[top];
                System.out.println(top + "\t" + candies[top] + "\t" + closed);
                vis[top] = true; // looted
                for (int nbr : containedBoxes[top])
                    bfs.add(nbr); // add to inventory
                for (int k : keys[top]) {
                    if (closed.contains(k)) {
                        closed.remove(k); // take out box from archive
                        bfs.add(k); // add to inventory
                    }
                    status[k] = 1; // unlock box
                }
            }
        }
        return candyCt;
    }
}