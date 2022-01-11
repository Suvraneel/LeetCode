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
    int sumRootToLeaf(TreeNode* root) {
        recur(root, 0);
        return (res);
    }
    
    void recur(TreeNode* node, int currVal){
        if (!(node))
            return;
        currVal = (currVal << 1) + node->val;
        if(!(node->right) && !(node->left)){
            res += currVal;
            cout << currVal << endl;
            return;
        }
        recur(node->left, currVal);
        recur(node->right, currVal);
    }
};