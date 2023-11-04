class Solution {
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        int ltmost = n, rtmost = 0;
        for(int ant: right)
            ltmost = min(ant, ltmost);
        for(int ant: left)
            rtmost = max(ant, rtmost);
        return max(n-ltmost, rtmost-0);
    }
};