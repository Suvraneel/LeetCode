class StockSpanner {
public:
    stack<pair<int, int>> stk;  // {price, streak}
    
    int next(int price) {
        int streak=1;
        while(!stk.empty() && stk.top().first<=price){
            streak+=stk.top().second;
            stk.pop();
        }
        stk.push({price, streak});
        return streak;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */