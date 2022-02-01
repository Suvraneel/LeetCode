class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxm = INT_MIN, minm = INT_MAX;
        for (int p: prices){
            minm = min(minm, p);
            maxm = max(maxm, p-minm);
        }
        return maxm;
    }
};