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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        ListNode marker = head, curr = head;
        int count = 0;
        while (curr != null && count++ <= k)
            curr = curr.next;
        if (count <= k) { // i.e., has not crossed k
            k %= count;
            if (k == 0)
                return head;
            curr = head;
            count = 0;
            while (curr != null && count++ <= k)
                curr = curr.next;
        }
        while (curr != null) {
            curr = curr.next;
            marker = marker.next;
            count++;
        }
        ListNode newHead = marker.next;
        marker.next = null;
        curr = newHead;
        while (curr.next != null)
            curr = curr.next;
        curr.next = head;
        return newHead;
    }
}