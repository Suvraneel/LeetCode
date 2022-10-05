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
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(depth==1){    // base case (root case)
            TreeNode* oldRoot = root;
            root= new TreeNode(val, oldRoot, nullptr);
        }
        queue<TreeNode*> q;
        q.push(root);
        TreeNode* cur;
        int d=1, ct=1;  // depth & count of nodes in each level
        while(!q.empty()){
            if(d==depth-1){ // after parents of required depth found
                while(!q.empty()){  // Loop ==> can be made into a different fx altogether
                    cur = q.front();
                    if(cur){
                        TreeNode* lt=cur->left;
                        TreeNode* rt=cur->right;
                        cur->left= new TreeNode(val, lt, nullptr);
                        cur->right= new TreeNode(val, nullptr, rt);
                    }
                    q.pop();
                }
                return root;
            }
            // Usual loop until parents of reqd depth has not been reached
            cur = q.front();
            if(cur){
                q.push(cur->left);
                q.push(cur->right);
            }
            q.pop();
            if(!(--ct))
                ct=q.size(), d++;
        }
        return root;
    }
};