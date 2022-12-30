class Solution {
public:
    vector<vector<int>> res;
    vector<int> v;
    void dfs(vector<vector<int>>& graph, int curr=0) {   //dfs
        v.push_back(curr);
        if(curr==graph.size()-1)
            res.push_back(v);
        else for(int nd: graph[curr])
            dfs(graph, nd);
        v.pop_back();
    }
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph){
        dfs(graph);
        return res;
    }
};