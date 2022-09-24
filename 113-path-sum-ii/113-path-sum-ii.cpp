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
    vector<vector<int>> res;
    vector <int> v;
    
    void solve(TreeNode* root, int targetSum, int currSum) {
        if(!root)
            return;
        v.push_back(root->val);
        currSum += root->val;
        if(!root->left && !root->right && targetSum==currSum)
                res.push_back(v);
        solve(root->left, targetSum, currSum);
        solve(root->right, targetSum, currSum);
        v.pop_back();
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        solve(root, targetSum, 0);
        return res;
    }
};