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
    public ListNode modifiedList(int[] nums, ListNode head) {
    Set<Integer> del = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        ListNode curr = head, dummy = new ListNode(0, head), prev = dummy;
        while(curr!=null){
            while(curr!=null && del.contains(curr.val))
                curr = curr.next;
            prev.next = curr;
            if(curr==null)
                break;
            curr = curr.next;
            prev = prev.next;
        }
        return dummy.next;
    }
}