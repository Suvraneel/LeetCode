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
    public boolean isBalanced(TreeNode root) {
        return solve(root) != -1;
    }

    int solve(TreeNode node) {
        if (node == null)
            return 0;
        int lt = solve(node.left);
        if (lt == -1)
            return -1;
        int rt = solve(node.right);
        if (rt == -1)
            return -1;
        if (Math.abs(lt - rt) > 1)
            return -1;
        return Math.max(lt, rt) + 1;
    }
}