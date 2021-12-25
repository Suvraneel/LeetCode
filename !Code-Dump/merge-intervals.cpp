class Solution {
public:
    // Note - The optimal solution is to use an Interval Tree Data Structure

    // Brute Force
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> res;
        if (intervals.size() == 1) return {intervals[0]};
        for(int i=1; i<intervals.size(); i++){
            cout << intervals[i-1][0] << " " << intervals[i-1][1] << " | ";
            if(intervals[i-1][1]>=intervals[i][0]){
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = max(intervals[i-1][1],intervals[i][1]);
                continue;
            }
            res.push_back(intervals[i-1]);
        }
        res.push_back(intervals[intervals.size()-1]);
        return res;
    }
};