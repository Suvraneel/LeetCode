class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int,int> m;
        int res = 0;
        for(auto t: tasks)  m[t]++;
        for(auto [_, e]:m){
            int triplets = floor(e/3);
            res += triplets;
            if(e%3==2)
                res++;
            else if(e%3){
                if(triplets)
                    res++;  // break down a previously counted triplet to make 2 duplets instead.
                else return -1;
            }
        }
        return res;
    }
};