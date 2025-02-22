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
    public TreeNode recoverFromPreorder(String traversal) {
        Map<Integer, TreeNode> levelParent = new HashMap<>();
        traversal += "-"; // ending dash so that last node is also processed completely
        TreeNode dummy = new TreeNode(-1);
        levelParent.put(-1, dummy);
        int level = 0, val = 0;
        for (char c : traversal.toCharArray()) {
            if (c == '-') {
                if (val != 0) {
                    TreeNode parent = levelParent.get(level - 1), newNode = new TreeNode(val);
                    if (parent.left != null)
                        parent.right = newNode;
                    else
                        parent.left = newNode;
                    levelParent.put(level, newNode);
                    val = 0;
                    level = 0;
                }
                level++;
            } else
                val = 10 * val + c - '0';
        }
        return dummy.left; // root
    }
}