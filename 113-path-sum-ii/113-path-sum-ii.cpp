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
    vector<vector<int>> res;
    vector <int> v;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum, int currSum=0) {
        if(!root)
            return res;
        v.push_back(root->val);
        currSum += root->val;
        if(!root->left && !root->right){
            if(targetSum==currSum)
                res.push_back(v);
        }
        pathSum(root->left, targetSum, currSum);
        pathSum(root->right, targetSum, currSum);
        v.pop_back();
        return res;
    }
};