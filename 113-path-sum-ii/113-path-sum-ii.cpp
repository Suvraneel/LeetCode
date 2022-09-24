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
    vector<vector<int>> pathSum(TreeNode* root, int targetSum, vector<int>v={}, int currSum=0) {
        if(!root)
            return res;
        v.push_back(root->val);
        currSum += root->val;
        if(!root->left && !root->right){
            if(targetSum==currSum)
                res.push_back(v);
            return res;
        }
        pathSum(root->left, targetSum, v, currSum);
        pathSum(root->right, targetSum, v, currSum);
        return res;
    }
};