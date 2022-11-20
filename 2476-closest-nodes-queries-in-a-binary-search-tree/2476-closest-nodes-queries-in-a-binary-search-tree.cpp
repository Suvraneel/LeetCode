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
    vector<int> v;
    
    void dfs(TreeNode* root){
        if(!root)
            return;
        dfs(root->left);
        v.push_back(root->val);
        dfs(root->right);
        return;
    }
    
    
    vector<vector<int>> closestNodes(TreeNode* root, vector<int>& queries) {
        vector<vector<int>> res;
        dfs(root);
        for(auto q: queries){
            int idx = lower_bound(v.begin(), v.end(), q) - v.begin();
            if(idx==v.size())
                res.push_back({v.back(),-1});
            else if(v[idx]==q)
                res.push_back({q,q});
            else res.push_back({idx>0?v[idx-1]:-1,v[idx]});
        }
        return res;
    }
};