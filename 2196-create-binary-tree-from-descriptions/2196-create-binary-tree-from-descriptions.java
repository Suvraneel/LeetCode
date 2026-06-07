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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> tree = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        int i = 0;
        // build graph/tree
        for (int[] desc : descriptions) {
            tree.putIfAbsent(desc[0], new TreeNode(desc[0], null, null));
            TreeNode child = tree.getOrDefault(desc[1], new TreeNode(desc[1]));
            tree.put(desc[1], child);
            if (desc[2] == 1) {
                tree.get(desc[0]).left = child;
            } else {
                tree.get(desc[0]).right = child;
            }
            children.add(desc[1]);
        }
        // identify root node
        for (int key : tree.keySet())
            if (!children.contains(key))
                return tree.get(key);
        return null;
    }
}