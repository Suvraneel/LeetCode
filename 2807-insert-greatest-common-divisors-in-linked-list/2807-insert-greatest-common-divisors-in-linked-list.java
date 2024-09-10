/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head, next = head.next;
        while (next != null) {
            int gcd = findGCD(curr.val, next.val);
            curr.next = new ListNode(gcd, next);
            curr = next;
            next = next.next;
        }
        return head;
    }

    private int findGCD(int a, int b) {
        if (a == 0)
            return b;
        return findGCD(b % a, a);
    }
}