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
    bool valid=false;
    bool hasPathSum(TreeNode* root, int targetSum) {
        if(valid)   return true;    // skip if already found path
        if(!root)   return false;
        if(!root->left && !root->right && targetSum==root->val)     return valid=true;
        return hasPathSum(root->left, targetSum-root->val)||hasPathSum(root->right, targetSum-root->val);
    }
};