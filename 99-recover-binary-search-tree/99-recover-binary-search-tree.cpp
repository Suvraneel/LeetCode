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
	TreeNode* firstMistake, *secondMistake, *prev;
	void recoverTree(TreeNode* root) {
		prev = new TreeNode(INT_MIN);
		inorder(root);
		swap(firstMistake->val, secondMistake->val);
	}

	void inorder(TreeNode* root) {
        // null ptr check
		if(root == nullptr) 
			return;

		inorder(root->left);
        
		if(firstMistake == nullptr && root->val < prev->val)    // if 1st mistake is not yet marked
			firstMistake = prev;
		if(firstMistake != nullptr && root->val < prev->val)    // if 1st mistake isSet already
			secondMistake = root;
		prev = root;

		inorder(root->right);
	}
};