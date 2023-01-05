class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int ct = 0, minX = points[0][1];
        for(int i=0; i<points.size(); i++)
            if(points[i][0]>minX)   ct++, minX = points[i][1];
            else minX = min(minX, points[i][1]);
        return ++ct;
    }
};