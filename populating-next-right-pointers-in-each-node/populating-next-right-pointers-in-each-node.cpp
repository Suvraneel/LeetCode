/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    vector<queue <Node*>> v;
    bool firstTime = true;  // Meme reference : https://knowyourmeme.com/memes/james-franco-first-time
    Node* connect(Node* root, int lvl=0) {
        // Execute in first run only
        if (firstTime){
            if (!(root))
                return root;
            auto ptr = root;
            while(ptr->left){
                v.push_back(queue<Node*>());
                ptr = ptr->left;
            }
            firstTime = false;
        }
        if (root->left){
            root->left->next = root->right;
            if (!(v[lvl].empty())){//This auto-handles tree's left-most border `/`
            (v[lvl].front())->next = root->left;
            v[lvl].pop();
            }
            connect(root->left, lvl+1);
        }
        if (root->right){
            //dont push tree's right-most border `\`(Their next must remain null)
            v[lvl].push(root->right);
            connect(root->right, lvl+1);
        }
        return root;
    }
};