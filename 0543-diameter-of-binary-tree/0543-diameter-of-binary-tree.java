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
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return ans;
    }

    int solve(TreeNode node) {
        if (node == null)
            return 0;
        int lt = solve(node.left);
        int rt = solve(node.right);
        ans = Math.max(ans, lt + rt);
        return Math.max(lt, rt) + 1;
    }
}