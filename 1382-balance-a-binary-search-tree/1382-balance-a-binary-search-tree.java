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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        return generateBST(inOrder, 0, inOrder.size() - 1);
    }

    private void inOrderTraversal(TreeNode root, List<Integer> inOrder) {
        if (root == null)
            return;
        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inOrderTraversal(root.right, inOrder);
    }

    private TreeNode generateBST(List<Integer> inOrder, int lt, int rt) {
        if (lt > rt)
            return null;
        int mid = (lt + rt) / 2;
        TreeNode ltSubTree = generateBST(inOrder, lt, mid - 1);
        TreeNode rtSubTree = generateBST(inOrder, mid + 1, rt);
        TreeNode node = new TreeNode(inOrder.get(mid), ltSubTree, rtSubTree);
        return node;
    }
}