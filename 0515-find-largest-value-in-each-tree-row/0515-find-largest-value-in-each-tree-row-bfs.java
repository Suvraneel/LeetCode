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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size(), maxm = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                maxm = Math.max(maxm, node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            ans.add(maxm);
        }
        return ans;
    }
}