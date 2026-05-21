/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return solve(root, 0);
    }

    int solve(TreeNode node, int ht) {
        if (node == null)
            return ht;
        return Math.max(solve(node.left, ht + 1), solve(node.right, ht + 1));
    }
}