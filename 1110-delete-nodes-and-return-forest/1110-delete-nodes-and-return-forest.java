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
    List<TreeNode> forest = new ArrayList<>();

    private TreeNode dfs(TreeNode root, Set<Integer> del){
        if(root==null)
            return null;
        root.left = dfs(root.left, del);
        root.right = dfs(root.right, del);
        if(del.contains(root.val)){
            if(root.left!=null)
                forest.add(root.left);
            if(root.right!=null)
                forest.add(root.right);
            root = null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> del = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        root = dfs(root, del);
        if(root!=null)
            forest.add(root);
        return forest;
    }
}