class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int,int> m;
        int res = 0;
        for(auto t: tasks)  m[t]++;
        for(auto [_, e]:m){
            if(e==1)
                return -1;
            res += e/3;
            if(e%3) res++;
        }
        return res;
    }
};