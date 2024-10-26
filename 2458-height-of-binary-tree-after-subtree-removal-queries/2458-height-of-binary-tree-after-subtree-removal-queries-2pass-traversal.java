/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxHtYet = 0, idx = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> htAfterRm = new HashMap<>();
        traverseLtToRt(root, htAfterRm, 0);
        maxHtYet = 0;
        traverseRtToLt(root, htAfterRm, 0);
        int[] ans = new int[queries.length];
        for (int q : queries)
            ans[idx++] = htAfterRm.get(q);
        return ans;
    }

    private void traverseLtToRt(TreeNode root, Map<Integer, Integer> htAfterRm, int depth) {
        if (root == null)
            return;
        htAfterRm.put(root.val, maxHtYet);
        maxHtYet = Math.max(maxHtYet, depth);
        traverseLtToRt(root.left, htAfterRm, depth + 1);
        traverseLtToRt(root.right, htAfterRm, depth + 1);
    }

    private void traverseRtToLt(TreeNode root, Map<Integer, Integer> htAfterRm, int depth) {
        if (root == null)
            return;
        htAfterRm.put(root.val, Math.max(maxHtYet, htAfterRm.get(root.val)));
        maxHtYet = Math.max(maxHtYet, depth);
        traverseRtToLt(root.right, htAfterRm, depth + 1);
        traverseRtToLt(root.left, htAfterRm, depth + 1);
    }

}