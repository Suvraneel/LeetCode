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
    StringBuilder rootToStart, rootToDest;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, destValue, new StringBuilder());
        // remove common path (ie, from root to last mutual ancestor
        int minPathLen = Math.min(rootToStart.length(), rootToDest.length()), i;
        for (i = 0; i < minPathLen; i++)
            if (rootToStart.charAt(i) != rootToDest.charAt(i))
                break;
        return "U".repeat(rootToStart.substring(i).length()) + rootToDest.substring(i);
    }

    private void dfs(TreeNode root, int startValue, int destValue, StringBuilder path) {
        if (root == null)
            return;
        if (root.val == startValue) {
            rootToStart = new StringBuilder(path);
        }
        if (root.val == destValue) {
            rootToDest = new StringBuilder(path);
        }
        dfs(root.left, startValue, destValue, path.append("L"));
        path.setLength(path.length() - 1);
        dfs(root.right, startValue, destValue, path.append("R"));
        path.setLength(path.length() - 1);
    }
}