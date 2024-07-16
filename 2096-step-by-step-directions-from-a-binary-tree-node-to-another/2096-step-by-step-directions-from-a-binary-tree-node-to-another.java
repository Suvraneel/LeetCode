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
    StringBuilder rootToNode = new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, new StringBuilder());
        StringBuilder rootToStart = new StringBuilder(rootToNode);
        rootToNode.setLength(0);
        dfs(root, destValue, new StringBuilder());
        StringBuilder rootToDest = new StringBuilder(rootToNode);
        // System.out.println(rootToStart +"\t"+ rootToDest);
        // remove common path (ie, from root to last mutual ancestor
        int minPathLen = Math.min(rootToStart.length(), rootToDest.length()), i;
        for(i=0; i<minPathLen; i++)
            if(rootToStart.charAt(i)!=rootToDest.charAt(i))
                break;
        // System.out.println(rootToStart +"\t"+ rootToDest);
        return "U".repeat(rootToStart.substring(i).length()) + rootToDest.substring(i);
    }
    private void dfs(TreeNode root, int destValue, StringBuilder path){
        if(root==null || rootToNode.length()!=0)
            return;
        if(root.val==destValue){
            rootToNode = new StringBuilder(path);
            return;
        }
        dfs(root.left, destValue, path.append("L"));
        path.setLength(path.length()-1);
        dfs(root.right, destValue, path.append("R"));
        path.setLength(path.length()-1);
    }
}