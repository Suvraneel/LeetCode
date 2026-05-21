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
    boolean unbalanced = false;

    public boolean isBalanced(TreeNode root) {
        solve(root);
        return !unbalanced;
    }

    int solve(TreeNode node) {
        if (node == null)
            return 0;
        int lt = 1 + solve(node.left), rt = 1 + solve(node.right);
        if (Math.abs(lt - rt) > 1)
            unbalanced = true;
        return Math.max(lt, rt);
    }
}