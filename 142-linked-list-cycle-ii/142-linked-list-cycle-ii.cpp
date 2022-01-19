/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if (!(head))
            return NULL;
        ListNode* slo = head;
        ListNode* fast = head;
        // ListNode* entry = head;
        while(fast->next && fast->next->next){
            slo = slo->next;
            fast = fast->next->next;
            if (slo==fast){//meet
                // while(slo!=entry){      reusing fast as entry pointer for less space complexity
                fast = head;
                while(slo!=fast){
                // entry = entry->next;
                fast = fast->next;
                slo = slo->next;
                }
                return slo;
            }
        }
        return NULL;
    }
};