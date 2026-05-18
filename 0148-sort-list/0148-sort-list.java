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
    public ListNode sortList(ListNode head) {
        return partition(head);
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode partition(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head), lt = head, rt = mid.next;
        mid.next = null;
        lt = partition(lt);
        rt = partition(rt);
        return merge(lt, rt);
    }

    private ListNode merge(ListNode lt, ListNode rt) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (lt != null && rt != null) {
            if (lt.val <= rt.val) {
                curr.next = lt;
                lt = lt.next;
            } else {
                curr.next = rt;
                rt = rt.next;
            }
            curr = curr.next;
        }
        if (lt != null)
            curr.next = lt;
        else if (rt != null)
            curr.next = rt;
        return dummy.next;
    }
}