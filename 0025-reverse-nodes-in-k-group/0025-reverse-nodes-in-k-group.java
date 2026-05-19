/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, kHead = curr, prev = null, dummy = new ListNode(0);
        ListNode[] newChain = null, lastChain = new ListNode[] { dummy, dummy };
        while (curr != null) {
            kHead = curr;
            int i = 0;
            while (curr != null && i < k) {
                prev = curr;
                curr = curr.next;
                i++;
            }
            if (i == k) {
                prev.next = null; // disconnect next chain
                newChain = reverseLL(kHead); // returns {head, tail} after reversal
                lastChain[1].next = newChain[0]; // connect lastChain tail -> newChain head
                lastChain = newChain;
            } else
                lastChain[1].next = kHead; // connect without reversal of remnants
        }
        return dummy.next;
    }

    /** Reverse a LinkedList
    * @return ListNode[]{head, tail}
    */
    private ListNode[] reverseLL(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return new ListNode[] { prev, head }; // {newHead, newTail}
    }
}