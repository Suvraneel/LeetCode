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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int nodesAtLevel = 1, currLevel = 0, res = 0;
        q.offer(root);
        List<Integer> nodesToSort = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode top = q.poll();
            if (top.left != null) {
                q.offer(top.left);
                nodesToSort.add(top.left.val);
            }
            if (top.right != null) {
                q.offer(top.right);
                nodesToSort.add(top.right.val);
            }
            if (--nodesAtLevel == 0) {
                nodesAtLevel = q.size();
                currLevel++;
                res += calcSwapOperations(nodesToSort);
                nodesToSort.clear();
            }
        }
        return res;

    }

    private int calcSwapOperations(List<Integer> nodesToSort) {
        List<Integer> target = new ArrayList<>(nodesToSort);
        Collections.sort(target);
        Map<Integer, Integer> ogMap = new HashMap<>();
        for (int i = 0; i < nodesToSort.size(); i++)
            ogMap.put(nodesToSort.get(i), i);
        int numsSwap = 0;
        for (int i = 0; i < target.size(); i++) {
            int og = nodesToSort.get(i), tgt = target.get(i);
            if (og != tgt) {
                numsSwap++;
                int swapIdx = ogMap.get(tgt);
                nodesToSort.set(i, tgt);
                nodesToSort.set(swapIdx, og);
                ogMap.put(tgt, i);
                ogMap.put(og, swapIdx);
            }
        }
        // System.out.println(nodesToSort);
        // System.out.println(numsSwap);
        return numsSwap;
    }
}