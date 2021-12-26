class Solution {
    
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector <vector<int>> dist, res;
        for (int i=0; i<points.size(); i++){
            dist.push_back({points[i][0]*points[i][0] + points[i][1]*points[i][1], i});
        }
        sort(dist.begin(), dist.end());
        for (int i=0; i<k; i++){
            res.push_back(points[dist[i][1]]);
            cout << points[dist[i][1]][0] << " " << points[dist[i][1]][1];
        }
        return res;
    }
};