/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        queue <Node*> q;
        vector<vector<int>> res;
        if(!root)
            return res;
        q.push(root);
        while (!(q.empty())){
            vector <int> v;
            int s = q.size();
            for(int i=0; i<s; i++){
                auto f = q.front();
                q.pop();
                for(auto n: f->children)
                    q.push(n);
                v.push_back(f->val);
            }
            res.push_back(v);
        }
        return res;
    }
};