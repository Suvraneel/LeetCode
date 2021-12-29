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
    vector<queue <Node*>> v;    // Vector of Queues
    bool firstTime = true;  // Meme reference : https://knowyourmeme.com/memes/james-franco-first-time
    Node* connect(Node* root, int lvl=0) {
        // Execute in first run only
        if (firstTime){
            if (!(root))
                return root;
            // Constructing empty queues for every level in tree
            auto ptr = root;
            while(ptr->left){
                v.push_back(queue<Node*>());
                ptr = ptr->left;
            }
            firstTime = false;
        }
        auto rootsLeft = root->left;
        auto rootsRight = root->right;
        if (rootsLeft){
            rootsLeft->next = rootsRight;
            if (!(v[lvl].empty())){// leftmost nodes are not the next of any node
            (v[lvl].front())->next = rootsLeft;
            v[lvl].pop();
            }
            connect(rootsLeft, lvl+1);
        }
        if (rootsRight){
            // next of tree's right-most border remains null
            v[lvl].push(rootsRight);
            connect(rootsRight, lvl+1);
        }
        return root;
    }
};