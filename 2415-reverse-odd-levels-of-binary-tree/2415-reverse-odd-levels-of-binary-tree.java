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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currLevel = 0, nodesAtLevel;
        while (!q.isEmpty()) {
            nodesAtLevel = q.size();
            List<TreeNode> currLevelNodes = new ArrayList<>();
            while (nodesAtLevel-- > 0) {
                TreeNode node = q.poll();
                currLevelNodes.add(node);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (currLevel % 2 == 1) {
                int lt = 0, rt = currLevelNodes.size() - 1;
                while (lt < rt) {
                    int temp = currLevelNodes.get(lt).val;
                    currLevelNodes.get(lt).val = currLevelNodes.get(rt).val;
                    currLevelNodes.get(rt).val = temp;
                    lt++;
                    rt--;
                }
            }
            currLevel++;
        }
        return root;
    }
}