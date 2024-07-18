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
    Map<TreeNode, List<TreeNode>> adjList = new HashMap<>();
    Set<TreeNode> leaves = new HashSet<>();
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root);
        }
        if (root.left != null) {
            adjList.computeIfAbsent(root, k -> new ArrayList<>()).add(dfs(root.left));
            adjList.computeIfAbsent(root.left, k -> new ArrayList<>()).add(root);
        }
        if (root.right != null) {
            adjList.computeIfAbsent(root, k -> new ArrayList<>()).add(dfs(root.right));
            adjList.computeIfAbsent(root.right, k -> new ArrayList<>()).add(root);
        }
        return root;
    }
    public int countPairs(TreeNode root, int distance) {
        dfs(root);  // Generate Adjacency List & leaf nodes
        int ans = 0;
        for(TreeNode leaf: leaves){     // shortest path algorithm for each destination (leaf)
            Queue<TreeNode> bfs = new LinkedList<>();   // to track 1+ hop neighbors of leaf
            Set<TreeNode> visited = new HashSet<>();
            bfs.add(leaf);
            visited.add(leaf);
            for(int i=0; i<=distance; i++){
                int n_iHopNeighbors = bfs.size();
                for(int j = 0; j<n_iHopNeighbors; j++){
                    TreeNode curr = bfs.poll();
                    if(leaves.contains(curr) && curr!=leaf)
                        ans++;
                    for(TreeNode neighborOfCurr: adjList.getOrDefault(curr, new ArrayList<>())){
                        if(!visited.contains(neighborOfCurr)){
                            bfs.add(neighborOfCurr);
                            visited.add(neighborOfCurr);
                        }
                    }
                }
            }
        }
        return ans/2;
    }
}