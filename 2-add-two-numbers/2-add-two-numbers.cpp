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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int CY=0;   // carry
        auto head = l1, prev=l1;
        while(l1 && l2)
            l1->val += l2->val+CY, CY=l1->val/10, l1->val%=10, prev=l1, l1=l1->next, l2=l2->next;
        if(l2)  prev->next=l2;  // if l2 longer than l1
        while(l2)   l2->val+=CY, CY=l2->val/10, l2->val%=10, prev=l2, l2=l2->next;   // if l2 longer than l1
        while(l1)   l1->val+=CY, CY=l1->val/10, l1->val%=10, prev=l1, l1=l1->next;   // if l1 longer than l2
        if(CY)  prev->next=new ListNode(CY);
        return head;
    }
};