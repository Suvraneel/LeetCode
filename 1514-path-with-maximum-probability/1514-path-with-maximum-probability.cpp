class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        vector<vector<pair<int, double>>> adjList(n);
        int i = 0;
        for(auto e: edges){
            int u = e[0], v = e[1];
            adjList[u].push_back({v, succProb[i]});
            adjList[v].push_back({u, succProb[i++]});
        }
        
        vector<double> prob(n, 0.0);    // cost to reach a node (here: probability)
        prob[start] = 1.0;
        queue <int> q;
        q.push(start);
        while (!q.empty()){
            int cur = q.front();
            q.pop();
            for(auto nbr: adjList[cur]){
                double prob_new = prob[cur] * nbr.second;
                if(prob_new > prob[nbr.first]){
                    prob[nbr.first] = prob_new;
                    // cout << cur << "---" << nbr.first << "<-" << prob_new << "\n";
                    q.push(nbr.first);
                }
            }
        }
        return prob[end];
    }
};