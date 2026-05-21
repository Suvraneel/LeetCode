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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        solve(root, pre);
        return pre;
    }

    void solve(TreeNode node, List<Integer> pre) {
        if (node == null)
            return;
        pre.add(node.val);
        solve(node.left, pre);
        solve(node.right, pre);
    }
}