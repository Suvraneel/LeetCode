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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        auto a=headA, b=headB;
        int cA=0, cB=0;
        while(a)
            a=a->next, cA++;
        while(b)
            b=b->next, cB++;
        a=headA, b=headB;
        if(cA>cB)
            swap(a,b), swap(cA, cB);
        int diff=cB-cA;
        while(diff--)   b=b->next;
        while(a&&b){
            if(a==b)    return a;
            a=a->next, b=b->next;
        }
        return nullptr;
    }
};