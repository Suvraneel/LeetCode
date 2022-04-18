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
    TreeNode* increasingBST(TreeNode* ptr) {
        auto ltToken = ptr;
        if (ptr){
            // cout << "\n#" << ptr->val;
            if (ptr->right){
                ptr->right = increasingBST(ptr->right);

            }
            if (ptr->left){
                ltToken = ptr->left;
                while(ltToken->left)
                    ltToken=ltToken->left;
                increasingBST(ptr->left);
                if (ptr->left->right){
                    auto s = ptr->left->right;
                    while (s->right)
                        s = s->right;
                    s->right = ptr;
                }
                else ptr->left->right = ptr;
                ptr->left = nullptr;
            }
        }
        return (ltToken ? ltToken : ptr);
    }
    
    int kthSmallest(TreeNode* root, int k) {
        TreeNode* newRoot = increasingBST(root);
        k--;
        while(k--){
            newRoot= newRoot->right;
            cout<< newRoot->val;}
        return newRoot->val;
    }
};