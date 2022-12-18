class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack <pair<int, int>> stk;
        for(int i=0; i<temperatures.size(); i++){
            while(!stk.empty() && temperatures[i]>stk.top().first){
                temperatures[stk.top().second]=i-stk.top().second;
                stk.pop();
            }
            stk.push({temperatures[i], i});
        }
        while(!stk.empty()){
            temperatures[stk.top().second]=0;
            stk.pop();
        }
        return temperatures;
    }
};