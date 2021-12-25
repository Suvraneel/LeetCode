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
    void reorderList(ListNode* head) {
        // split into 2 parts from middle
        auto h1 = head;
        auto h2 = head;
        while (h2!=NULL && h2->next!=NULL){
            h1 = h1->next;
            h2 = h2->next->next;
            // cout << h1->val << " ";
        }
        // currently h1 points to middle element... So detaching 2 parts for split
        h2 = h1->next; //head of 2nd half of LL
        h1->next = NULL;// detached
        h1 = head;
        
        // reverse 2nd 1/2 of LL
        auto prev = h2; prev = NULL;
        auto curr = h2;
        auto next = h2;
        while (curr!=NULL){
            next = curr->next;
            curr->next = prev;  // reversed link direction
            // Shift all pointers by one for successor loop's execution
            prev = curr;
            curr = next;
        }
        h2 = prev; // since prev is pointing to the new head of 2nd 1/2
        
        // merge 2 parts' nodes alternatively
        curr = h1;
        while(h1!=NULL && h2!=NULL){
            h1 = h1->next;
            curr->next = h2;
            curr = h2;
            h2 = h2-> next;
            curr->next = h1;
            curr = h1;
        }
    }
};