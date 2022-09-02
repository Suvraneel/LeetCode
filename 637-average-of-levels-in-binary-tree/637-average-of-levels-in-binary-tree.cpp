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
    vector<double> averageOfLevels(TreeNode* root) {
        queue<pair<TreeNode*, int>> q;  // Queue holds Node & its height from top
        vector <double> v;
        if(!root)
            return v;
        q.push({root, 0});  //init
        vector<pair<double, int>> sum_ct;   // Tracks level order sum & node ct for avg finding
        int visitedHt = -1; // current level being calculated
        while(!(q.empty())){    // FIFO yields level order
            auto f = q.front();
            // cout << f.first->val << "\t";
            if(visitedHt<f.second)  // init level
                sum_ct.push_back({0, 0});
            sum_ct[f.second].first += f.first->val;
            sum_ct[f.second].second++;
            visitedHt = max(visitedHt, f.second);
            q.pop();
            if(f.first->left)
                q.push({f.first->left, f.second+1});
            if(f.first->right)
                q.push({f.first->right, f.second+1});
        }
        for(int i=0; i<=visitedHt; i++)     // finally calc avg
            v.push_back(sum_ct[i].first/sum_ct[i].second);
        return v;
    }
};