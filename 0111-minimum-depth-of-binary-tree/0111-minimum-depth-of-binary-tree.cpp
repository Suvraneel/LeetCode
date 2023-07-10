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
    int depth = INT_MAX;
    int minDepth(TreeNode* root, int lvl=0) {
        if(!root)
            return 0;
        if(!(root->left) && !(root->right))
            depth = min(depth, lvl);
        minDepth(root->left, lvl+1);
        minDepth(root->right, lvl+1);
        return depth+1;
    }
};