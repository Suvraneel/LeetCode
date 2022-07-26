/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root)
            return root;
        if (root==p || root==q)
            return root;    // rets that node & its ancestor nodes in subsequent surface runs
        // dive in depth time
            auto ltNode = lowestCommonAncestor(root->left, p, q);
            auto rtNode = lowestCommonAncestor(root->right, p, q);
        // float to surface time
        if (ltNode && rtNode)   // both nodes found
            return root;
        return ltNode?ltNode:rtNode;    // if anyone of them is found & other is not found,
                                        // it is evident that the search was not allowed to 
                                        // visit such depth. This indicates only one possibility:
                                        // the node found must have been an ancestor of the one not 
                                        // found. Hence, return that found node as LCA
    }
};