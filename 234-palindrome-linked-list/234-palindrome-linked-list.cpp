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
    bool isPalindrome(ListNode* head) {
        vector <int> v;
        auto curr = head;
        while (curr){
            v.push_back(curr->val);
            curr = curr->next;
        }
        int stt = 0, end = v.size()-1;
        for(;stt<end; stt++, end--){
            if (v[stt]!=v[end])
                return false;
        }
        return true;
    }
};