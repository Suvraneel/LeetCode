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
    int depth = 0;
    int maxDepth(TreeNode* root, int d = 1) {
        if (!(root))
            return depth;
        depth = max(depth, d);
        if(root->left)
            maxDepth(root->left, d+1);
        if(root->right)
            maxDepth(root->right, d+1);
        return depth;
    }
};