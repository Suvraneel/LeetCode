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
    ListNode* insertionSortList(ListNode* head) {
        ListNode dummy(0);
        while (head != nullptr) {
            auto curr = head->next;
            auto it = &dummy;
            while (it->next != nullptr && it->next->val < head->val) {
                it = it->next;
            }
            head->next = it->next;
            it->next = head;
            head = curr;
        }
        
        return dummy.next;
    }
};