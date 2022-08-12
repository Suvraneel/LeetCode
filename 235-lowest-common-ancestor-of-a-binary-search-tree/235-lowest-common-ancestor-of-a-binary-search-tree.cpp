class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
       while(true){
           if(root->val>max(p->val,q->val))
               root = root->left;
           else if (root->val<min(p->val,q->val))
               root = root->right;
           else break;
       }
        return root;
    }
};