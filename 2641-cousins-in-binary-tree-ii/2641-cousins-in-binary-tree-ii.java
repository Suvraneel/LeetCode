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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int levelCount = 1, levelSum = root.val;
        while (!q.isEmpty()) {
            int nextLevelSum = 0;
            for (int i = 0; i < levelCount; i++) {
                TreeNode front = q.poll();
                front.val = levelSum - front.val;
                int siblingSum = (front.left != null ? front.left.val : 0)
                        + (front.right != null ? front.right.val : 0);
                nextLevelSum += siblingSum;
                if (front.left != null) {
                    front.left.val = siblingSum;
                    q.offer(front.left);
                }
                if (front.right != null) {
                    front.right.val = siblingSum;
                    q.offer(front.right);
                }
            }
            levelSum = nextLevelSum;
            levelCount = q.size();
        }
        return root;
    }
}