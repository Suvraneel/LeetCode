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
        Map<Integer, TreeNode> m = new HashMap<>();
        Set<Integer> parents = new HashSet<>(), children = new HashSet<>();
        for(int[] desc: descriptions){
            parents.add(desc[0]);
            children.add(desc[1]);
            TreeNode curr = m.getOrDefault(desc[0], new TreeNode(desc[0]));
            if(desc[2] == 1){
                curr.left = m.getOrDefault(desc[1], new TreeNode(desc[1]));
                m.put(desc[1], curr.left);
            } else {
                curr.right = m.getOrDefault(desc[1], new TreeNode(desc[1]));
                m.put(desc[1], curr.right);
            }
            m.put(desc[0], curr);
        }
        parents.removeAll(children);
        // System.out.println(m);
        return m.get(parents.iterator().next());
    }
}