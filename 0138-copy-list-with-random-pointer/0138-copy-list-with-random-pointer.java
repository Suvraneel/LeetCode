/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>(); // node => cloned node
        Node curr = head, dummy = new Node(0, null), clonedCurr = dummy;
        while (curr != null) {
            clonedCurr.next = new Node(curr.val, null);
            clonedCurr = clonedCurr.next;
            map.put(curr, clonedCurr);
            curr = curr.next;
        }
        curr = head;
        clonedCurr = dummy.next;
        while (curr != null) {
            clonedCurr.random = map.get(curr.random);
            curr = curr.next;
            clonedCurr = clonedCurr.next;
        }
        return dummy.next;
    }
}