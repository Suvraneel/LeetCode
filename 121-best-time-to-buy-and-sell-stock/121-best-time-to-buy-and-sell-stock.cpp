class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxm = INT_MIN, minm = INT_MAX;
        for (int i=0; i<prices.size(); i++){
            minm = min(minm, prices[i]);
            maxm = max(maxm, prices[i]-minm);
        }
        return maxm;
    }
};