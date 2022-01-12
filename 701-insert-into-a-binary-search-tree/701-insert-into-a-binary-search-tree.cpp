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
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        //Exception Handling in case of Empty BST
        if (!(root))
            return new TreeNode(val);
        
        bool childDir; //Direction of Child - Left(false) or Right(true)
        // Traverse given BST
        auto ptr = root;
        auto prev = ptr;
        while(ptr){
            prev = ptr;
            if (val>ptr->val){
                ptr = ptr->right;
                childDir = true;
            }
            else{ 
                ptr=ptr->left;
                childDir = false;
            }
        }
        // Insert `val` in correct child position
        if(childDir)
            prev->right = new TreeNode(val);
        else prev->left = new TreeNode(val);
        return root;
    }
};