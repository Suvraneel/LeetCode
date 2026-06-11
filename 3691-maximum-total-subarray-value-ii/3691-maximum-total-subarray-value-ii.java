class Solution {
    private class SegmentTree {
        int[][] tree;
        int[] nums;

        SegmentTree(int n, int[] nums) {
            this.tree = new int[4 * n][2];
            this.nums = nums;
        }

        void build(int idx, int lt, int rt) {
            if (lt == rt) {
                tree[idx][0] = tree[idx][1] = nums[lt];
                return;
            }
            int mid = (lt + rt) / 2;
            build(2 * idx + 1, lt, mid);
            build(2 * idx + 2, mid + 1, rt);
            tree[idx] = new int[] { Math.max(tree[2 * idx + 1][0], tree[2 * idx + 2][0]),
                    Math.min(tree[2 * idx + 1][1], tree[2 * idx + 2][1]) };
        }

        int[] query(int idx, int stlt, int strt, int lt, int rt) {
            if (rt < stlt || lt > strt) // out of range
                return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
            if (lt <= stlt && rt >= strt) // partial query result
                return tree[idx];
            int stmid = (stlt + strt) / 2;
            int[] n1 = query(2 * idx + 1, stlt, stmid, lt, rt);
            int[] n2 = query(2 * idx + 2, stmid + 1, strt, lt, rt);
            return new int[] { Math.max(n1[0], n2[0]), Math.min(n1[1], n2[1]) };
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] node : tree)
                sb.append("[").append(Arrays.toString(node)).append("]");
            return sb.toString();
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n, nums);
        st.build(0, 0, n - 1);
        // System.out.println(st);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - b[1]) - (a[0] - a[1]));
        for (int i = 0; i < n; i++) {
            int[] node = st.query(0, 0, n - 1, i, n - 1);
            pq.offer(new int[] { node[0], node[1], i, n - 1 });
        }
        long ans = 0l;
        while (k-- > 0) {
            int[] node = pq.poll();
            ans += node[0] - node[1];
            int lt = node[2], rt = node[3];
            if (lt < rt) {
                node = st.query(0, 0, n - 1, lt, rt - 1);
                pq.offer(new int[] { node[0], node[1], lt, rt - 1 });
            }
        }
        return ans;
    }
}