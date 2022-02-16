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
    ListNode* swapPairs(ListNode* head) {
        ListNode* node=head;
        ListNode* after = NULL;
        if (node && node->next)
            after=node->next;
        int temp;
        while(node && after){
            temp = node->val;
            node->val = after->val;
            after->val = temp;
            if(after->next)
                node = after->next;
            else break;
            after= node->next;
        }
        return head;
    }
};