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
    int res = 0;
    TreeNode* recur(TreeNode* root, int minN, int maxN){
        int value = root->val;
        minN = min(minN, value);
        maxN = max(maxN, value);
        res = max(res, max(value-minN, maxN-value));
        if (root->left){
            recur(root->left, minN, maxN);
        }
        if (root->right){
            recur(root->right, minN, maxN);
        }
        return root; //returns NULL
    }
    
    int maxAncestorDiff(TreeNode* root) {
        recur(root, 100000, 0);
        return res;
    }
};