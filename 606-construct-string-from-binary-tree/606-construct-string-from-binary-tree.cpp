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
    string solve(TreeNode* root){
        string s = "";
        if(!root)
            return "";
        if(root->left && root->right)
            s += "(" + solve(root->left) + ")(" + solve(root->right) + ")";
        else if(!(root->left) && root->right)
            s += "()(" + solve(root->right) + ")";
        else if(!(root->left) && !(root->right));
        else s += "(" + solve(root->left) + ")";
        
        
        return to_string(root->val) + s ;
    }
    
    string tree2str(TreeNode* root) {
        return solve(root);
    }
};