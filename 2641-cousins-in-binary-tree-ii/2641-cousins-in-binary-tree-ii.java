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
        ArrayList<Integer> levelSums = new ArrayList<>();
        q.offer(root);
        int levelCount = 1;
        while (!q.isEmpty()) {
            int levelSum = 0;
            for (int i = 0; i < levelCount; i++) {
                TreeNode front = q.poll();
                levelSum += front.val;
                if (front.left != null)
                    q.offer(front.left);
                if (front.right != null)
                    q.offer(front.right);
            }
            levelSums.add(levelSum);
            levelCount = q.size();
        }
        // System.out.println(levelSums);
        modify(root, 0, root.val, levelSums);
        return root;
    }

    private void modify(TreeNode root, int depth, int siblingsSum, List<Integer> levelSums) {
        if (root == null)
            return;
        root.val = levelSums.get(depth) - siblingsSum;
        int childrenSum = (root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0);
        modify(root.left, depth + 1, childrenSum, levelSums);
        modify(root.right, depth + 1, childrenSum, levelSums);
    }
}