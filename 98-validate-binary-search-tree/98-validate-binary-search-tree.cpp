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
    // Simple Soln : Do InOrder Traversal -> must be strictly increasing
    long int maxm = LONG_MIN;
    bool valid = true;
    
    bool isValidBST(TreeNode* root) {
        if(!(root)) return true;
        auto lt = root->left;
        auto rt = root->right;
        if(lt)
            isValidBST(lt);
        cout << root->val << ", ";
        valid = valid && (maxm<root->val);
        cout << maxm;
        maxm = maxm>root->val?maxm:root->val;
        if(rt)
            isValidBST(rt);
        return valid;
    }
};