#include <bits/stdc++.h>
using namespace std;
typedef long int ll;
typedef long double ld;
#define T int tt; cin >> tt; while(tt--)
#define infLoop while(true)
#define pb insert
#define mp make_pair
#define forn(i, n) for(ll i = 0; i < n; i++)
#define fora(i, a, n) for(ll i = a; i < n; i++)
#define forr(i, a, n) for(ll i = n-1; i >= a; i--)
const int M = 1e9+7;

void fastio(){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
}

// Approach
// Start from all leaf nodes 7 start removing them one by one... The ones left at last is the answer

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


int main(){
    fastio();
    // vector<vector<int>> edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
    vector<vector<int>> edges = {{1,0},{1,2},{1,3}};
    vector<int> res = findMinHeightTrees(4, edges);
    for (int it; it<res.size(); it++){
        cout << res[it] << endl;
    }
    return 0;
}