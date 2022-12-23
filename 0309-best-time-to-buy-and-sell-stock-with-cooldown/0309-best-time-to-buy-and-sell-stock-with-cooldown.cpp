class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() < 2) return 0;
        int s0 = 0, s1 = -prices[0], s2 = 0;
        for (int i = 1; i < prices.size(); ++i) {
            int last_s2 = s2;
            s2 = s1 + prices[i];
            s1 = max(s0 - prices[i], s1);
            s0 = max(s0, last_s2);
        }
        return max(s0, s2);
    }
};