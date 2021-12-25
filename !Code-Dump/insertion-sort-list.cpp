
#include <bits/stdc++.h>
using namespace std;
typedef long int ll;
typedef long double ld;
#define T int tt; cin >> tt; while(tt--)
#define infLoop while(true)
#define pb push_back
#define mp make_pair
#define forn(i, n) for(ll i = 0; i < n; i++)
#define fora(i, a, n) for(ll i = a; i < n; i++)
#define forr(i, a, n) for(ll i = n-1; i >= a; i--)
const int M = 1e9+7;

void fastio(){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
}

//  Definition for singly-linked list.
 struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
 };

class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        auto curr = head;
        while(curr != NULL){
            auto ptr = curr;
            int value = curr->val;
            while (ptr->val>value)
                
        curr = curr->next;
        }
        cout << head->val;
        return head;
    }
};

int main(){
    auto last = ListNode(4);
    auto head = ListNode(3, last);
    insertionSortList(head);
}