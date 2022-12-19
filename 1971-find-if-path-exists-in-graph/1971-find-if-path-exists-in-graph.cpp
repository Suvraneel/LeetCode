class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<bool>vis(n,false);
        vector<vector<int>> adj(n, vector<int>());
        for(auto e: edges){
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        queue<int> bfs;
        bfs.push(source);
        vis[source]=true;
        while(!bfs.empty()){
            int node = bfs.front();
            for(int neighbor: adj[node]){
                if(vis[neighbor])   // skip if already visited
                    continue;
                bfs.push(neighbor);
                vis[neighbor]=true;
            }
            bfs.pop();
        }
        return vis[destination];
    }
};