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

    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }

    int[] traverse(TreeNode root) { // post order
        if (root == null)
            return new int[] { 0, 0 };
        int[] ltSubTree = traverse(root.left), rtSubTree = traverse(root.right);
        int sum = ltSubTree[0] + rtSubTree[0] + root.val, ct = ltSubTree[1] + rtSubTree[1] + 1;
        if (root.val == sum / ct)
            ans++;
        return new int[] { sum, ct };
    }
}