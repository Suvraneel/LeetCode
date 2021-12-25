class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        //corner case
        if ( n <= 1 ) return {0};

        vector<unordered_set<int>> graph(n);    // adjacency list fmt
        for (auto e : edges) {
            graph[e[0]].insert(e[1]);
            graph[e[1]].insert(e[0]);
        }

        //leaf nodes
        vector<int> leaf;
        for (int i=0; i<graph.size(); i++){
            if (graph[i].size() == 1)  leaf.push_back(i);
        }

        // BFS the graph
        while (true) {
            vector<int> nextLeaf;
            for (int node : leaf) {
                for (int neighbor : graph[node]) {
                    graph[neighbor].erase(node);
                    if (graph[neighbor].size() == 1) nextLeaf.push_back(neighbor);  // means it has become a leaf node itself
                }
            }
            if (nextLeaf.empty()) break;
            leaf = nextLeaf;
        }
        return leaf;
    }
};