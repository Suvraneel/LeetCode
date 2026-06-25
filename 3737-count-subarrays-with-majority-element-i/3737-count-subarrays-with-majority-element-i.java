class Solution {

    int target;
    int[] nums;

    class SegmentTree {
        int[] tree;

        SegmentTree(int n) {
            this.tree = new int[4 * n];
        }

        void build(int idx, int lt, int rt) {
            if (lt == rt) {
                tree[idx] = (nums[lt] == target) ? 1 : 0;
                return;
            }
            int mid = (lt + rt) / 2;
            build(2 * idx + 1, lt, mid);
            build(2 * idx + 2, mid + 1, rt);
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }

        int query(int idx, int lt, int rt, int qlt, int qrt) {
            if (rt < qlt || lt > qrt) // out of bounds
                return 0;
            if (lt >= qlt && rt <= qrt)
                return tree[idx];
            int mid = (lt + rt) / 2;
            return query(2 * idx + 1, lt, mid, qlt, qrt)
                    + query(2 * idx + 2, mid + 1, rt, qlt, qrt);
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length, ans = 0;
        SegmentTree tree = new SegmentTree(n);
        tree.build(0, 0, n - 1);
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                // System.out.println("[" + i + "," + j + "]->"
                //         + tree.query(0, 0, n - 1, i, j) + "->" + ((j - i + 1) / 2f));
                ans += (tree.query(0, 0, n - 1, i, j) > (j - i + 1) / 2f) ? 1 : 0;
            }
        return ans;
    }
}