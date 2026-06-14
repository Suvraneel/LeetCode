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
    public int pairSum(ListNode head) {
        // Find head of latter half (i.e., middle node)
        ListNode mid = findMiddle(head);
        // Reverse latter half of LL (new head is the last node of the OG LL)
        ListNode newHead = reverseLL(mid);
        // print(head); // note this will have 1 extra node (which is the mid), disregard it
        // print(newHead);
        int ans = Integer.MIN_VALUE;
        while (newHead != null) {
            ans = Math.max(ans, newHead.val + head.val);
            newHead = newHead.next;
            head = head.next;
        }
        return ans;
    }

    void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverseLL(ListNode head) {
        ListNode curr = head, prev = null, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}