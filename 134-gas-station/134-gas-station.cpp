class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int res = 0;
        
        // impossible case
        for(int i=0; i<gas.size(); i++){
            res += gas[i] - cost[i];
        }
        if (res < 0)
            return -1;
        
        // normal case
        res = gas[0];
        int ct = 0, idx = 0;
        for(int i=0; ct<gas.size(); i=(i+1)%gas.size()){
            res -= cost[i];
            ct++;
            if(res < 0){
                ct = 0;
                res = 0;
                idx = (i+1)%gas.size();
            }
            res += gas[(i+1)%gas.size()];
        }
        return idx;
    }
};