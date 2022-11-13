/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void swap(vector<int> &arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    int findMinSwaps(queue<TreeNode*>q){
        vector<int> arr;
        while(!q.empty()){
            arr.push_back(q.front()->val);
            q.pop();
        }
        int ans = 0, N=arr.size();
        vector<int>temp = arr;
        map <int, int> h;
        sort(temp.begin(), temp.end());
        for (int i = 0; i < N; i++)
        h[arr[i]] = i;
        for (int i = 0; i < N; i++){
            if (arr[i] != temp[i]){
              ans++;
              int init = arr[i];
              swap(arr, i, h[temp[i]]);
              h[init] = h[temp[i]];
              h[temp[i]] = i;
            }
        }
        return ans;
    }
    
    int minimumOperations(TreeNode* root) {
        int res=0;
        queue<TreeNode*> q;
        q.push(root);
        int ct=1;
        while (!q.empty()) {
            TreeNode* node = q.front();
            ct--, q.pop();
            if (node->left)
                q.push(node->left);
            if (node->right)
                q.push(node->right);
            if(!ct)
                ct=q.size(), res+=findMinSwaps(q);
        }
        return res;
    }
};