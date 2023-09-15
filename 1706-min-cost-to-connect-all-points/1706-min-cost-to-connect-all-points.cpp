class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& pts) {
        int n=pts.size(), cost=0, i=0;
        vector <int> d(n, INT_MAX-1);
        for(int connected=0; ++connected < n;){
            d[i]=INT_MAX;
            int nearest = i;
            for(int j=0; j<n; ++j){
                if(d[j]!=INT_MAX){  // isConnected?
                    d[j]=min(d[j], abs(pts[j][0]-pts[i][0])+abs(pts[j][1]-pts[i][1]));
                    nearest = d[j]<d[nearest]?j:nearest;
                }
            }
            i=nearest;
            cost+=d[i];
        }
        return cost;
    }
};