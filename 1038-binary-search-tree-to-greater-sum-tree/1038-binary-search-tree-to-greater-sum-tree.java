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
    private int solve(TreeNode root, int currSum){
        if(root==null)
            return currSum;
        int rtSubTree = solve(root.right, currSum);
        int ltSubTree = solve(root.left, root.val += rtSubTree);
        return ltSubTree;
    }
    public TreeNode bstToGst(TreeNode root) {
        solve(root, 0);
        return root;
    }
}