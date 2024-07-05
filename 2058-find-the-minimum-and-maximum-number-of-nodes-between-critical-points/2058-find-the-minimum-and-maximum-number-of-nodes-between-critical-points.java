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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int idx = 0;
        ListNode curr = head.next, prev = head, next = curr.next;
        List<Integer> criticalPts = new ArrayList<>();
        int[] ans = {Integer.MAX_VALUE, 0};
        while (next != null) {
            if (prev.val < curr.val && curr.val > next.val
                    || prev.val > curr.val && curr.val < next.val)
                criticalPts.add(idx);
            prev = curr;
            curr = curr.next;
            next = curr.next;
            idx++;
        }
        if(criticalPts.size()<2)
            return new int[] {-1, -1};
        for(int i=1; i<criticalPts.size(); i++)
            ans[0] = Math.min(ans[0], criticalPts.get(i)-criticalPts.get(i-1));
        ans[1] = criticalPts.get(criticalPts.size()-1) - criticalPts.get(0);
        return ans;
    }
}