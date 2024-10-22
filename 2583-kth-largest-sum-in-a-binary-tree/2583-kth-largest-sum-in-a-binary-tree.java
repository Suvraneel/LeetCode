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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Long> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        long nodesInLevel = 1, levelSum = 0;
        while (!q.isEmpty()) {
            TreeNode top = q.poll();
            levelSum += top.val;
            if (top.left != null)
                q.offer(top.left);
            if (top.right != null)
                q.offer(top.right);
            nodesInLevel--;
            if (nodesInLevel == 0) {
                pq.offer(levelSum);
                levelSum = 0;
                nodesInLevel = q.size();
            }
        }
        if (pq.size() < k)
            return -1;
        while (!pq.isEmpty() && --k > 0)
            pq.poll();
        return pq.poll();
    }
}