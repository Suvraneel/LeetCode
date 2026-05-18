/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int i = 0, j = 0;
        for (; curr != null; i++)
            curr = curr.next;
        curr = headB;
        for (; curr != null; j++)
            curr = curr.next;
        int diff = i - j;
        if (diff < 0) {
            diff = -diff;
            while (diff-- > 0)
                headB = headB.next;
        } else {
            while (diff-- > 0)
                headA = headA.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}