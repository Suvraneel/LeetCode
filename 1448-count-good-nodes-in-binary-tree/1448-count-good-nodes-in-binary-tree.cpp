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
    int ct = 0;
    int goodNodes(TreeNode* root, int maxm = INT_MIN) {
        if(root && root->val>=maxm){
            ct++;
            // cout << root->val << "\t";
        }
        if(root->left)
            goodNodes(root->left, max(maxm, root->val));
        if(root->right)
            goodNodes(root->right, max(maxm, root->val));
        return ct;
    }
};