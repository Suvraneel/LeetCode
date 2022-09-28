/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* lt=head;
        ListNode* rt=head;
        while(rt && n--)
            rt=rt->next;
        if(!rt){
            if(!n)
                return head->next;
            return head;
        }
        while(rt->next){
            lt=lt->next;
            rt=rt->next;
        }
        lt->next=lt->next->next;
        return head;
    }
};