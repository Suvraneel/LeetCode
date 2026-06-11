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

            tree[idx][0] = Math.max(
                tree[2 * idx + 1][0],
                tree[2 * idx + 2][0]
            );

            tree[idx][1] = Math.min(
                tree[2 * idx + 1][1],
                tree[2 * idx + 2][1]
            );
        }

        int[] query(int idx, int stlt, int strt, int lt, int rt) {

            if (rt < stlt || lt > strt) {
                return new int[] {
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE
                };
            }

            if (lt <= stlt && strt <= rt) {
                return tree[idx];
            }

            int stmid = (stlt + strt) / 2;

            int[] n1 = query(
                2 * idx + 1,
                stlt,
                stmid,
                lt,
                rt
            );

            int[] n2 = query(
                2 * idx + 2,
                stmid + 1,
                strt,
                lt,
                rt
            );

            return new int[] {
                Math.max(n1[0], n2[0]),
                Math.min(n1[1], n2[1])
            };
        }
    }

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        SegmentTree st = new SegmentTree(n, nums);
        st.build(0, 0, n - 1);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int l = 0; l < n; l++) {

            int[] res = st.query(
                0,
                0,
                n - 1,
                l,
                n - 1
            );

            pq.offer(new int[] {
                res[0] - res[1], // value
                l,               // left
                n - 1            // right
            });
        }

        long ans = 0;

        while (k-- > 0 && !pq.isEmpty()) {

            int[] cur = pq.poll();

            int value = cur[0];
            int l = cur[1];
            int r = cur[2];

            ans += value;

            if (r > l) {

                int[] res = st.query(
                    0,
                    0,
                    n - 1,
                    l,
                    r - 1
                );

                pq.offer(new int[] {
                    res[0] - res[1],
                    l,
                    r - 1
                });
            }
        }

        return ans;
    }
}