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
        auto lt=head, rt=head;
        while(n--){
            rt=rt->next;
            if(!rt)
                break;
        }
        if(rt)
            while(rt->next){
                lt=lt->next;
                rt=rt->next;
            }
        else
            if(lt==head && !rt)
                return head->next;
        // cout<<lt->val;
        lt->next=lt->next->next;
        return head;
    }
};