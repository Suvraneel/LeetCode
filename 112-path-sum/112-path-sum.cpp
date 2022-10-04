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
        if(!root)
            return false;
        if(!root->left && !root->right && targetSum==root->val)
            return valid=true;
        valid |= hasPathSum(root->left, targetSum-root->val);
        valid |= hasPathSum(root->right, targetSum-root->val);
        return valid;
    }
};