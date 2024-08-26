/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> li = new ArrayList<>();
        solve(root, li);
        return li;
    }
    private void solve(Node curr, List<Integer> li){
        if(curr==null)
            return;
        for(Node child: curr.children)
            solve(child, li);
        li.add(curr.val);
    }
}