class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int active = points[0][1];
        int count = 1;
        for(vector<int> e : points){
            if (active>=e[0]){
                active = min(active, e[1]);
            }
            else{ 
                active = e[1];
                count++;
            }
        }
        return count;
    }
};