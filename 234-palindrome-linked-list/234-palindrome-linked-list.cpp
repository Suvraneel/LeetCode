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

// O(3n)
// class Solution {
// public:
//     bool isPalindrome(ListNode* head) {
//         vector <int> v;
//         auto slow = head, fast = head;
//         bool odd = false;
//         while (fast){
//             fast = fast->next;
//             if (fast){
//                 fast=fast->next;
//                 slow = slow->next;
//             } else odd = true;
//         }
//         // slow is at middle... rotate the 1st part of LL
//         auto curr = head, succ = head, prev = head;
//         prev = NULL;
//         for (;curr!=slow;){
//             succ = curr->next;
//             curr->next = prev;
//             prev = curr;
//             curr = succ;
//         }
//         // if odd, then leave the index slow was at... else start from there
//         if (odd)
//             slow = slow->next;
//         // prev is at the head of 1st part, slow is at head of second
//         while(slow && prev){
//             // cout << prev->val << "============" << slow->val << endl;
//             if (prev->val!=slow->val)
//                 return false;
//             prev = prev->next;
//             slow= slow->next;
//         }
//         return true;
//     }
// };




// O(2n)
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        auto slow=head, fast=head, prev=head, prevv=head;
        prev=nullptr;
        while(fast && fast->next){
            fast=fast->next->next;
            prevv = prev;
            prev = slow;
            slow=slow->next;
            prev->next=prevv;
        }
        if(fast)    // odd palindrome ?
            slow=slow->next;
        while(slow){
            // cout << slow->val << "=?" << prev->val << endl;
            if(slow->val!=prev->val)
                return false;
            slow=slow->next;
            prev=prev->next;
        }
        return true;
    }
};