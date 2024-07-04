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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next, modder = head;
        int runningSum = 0;
        while (curr != null) {
            if (curr.val == 0) {
                modder.next = new ListNode(runningSum, null);
                modder = modder.next;
                runningSum = 0;
            } else
                runningSum += curr.val;
            curr = curr.next;
        }
        return head.next;
    }
}