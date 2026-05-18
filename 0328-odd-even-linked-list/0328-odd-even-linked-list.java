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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode headOdd = head, head2 = head.next, headEven = head.next;
        while (headOdd.next != null && headEven.next != null) {
            headOdd.next = headEven.next;
            headOdd = headOdd.next;
            headEven.next = headOdd.next;
            headEven = headEven.next;
        }
        headOdd.next = head2;
        return head;
    }
}