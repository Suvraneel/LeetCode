class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        for(int i:nums)
            m[i]++;
        int res=0;
        for(auto e:m){
            if(k==0){    
                if(e.second>1)                  // same element present twice, hence 0-diff holds
                res++;
            }
            else if(m.find(e.first+k)!=m.end())        // if k-diff found
                res++;
        }
        return res;
    }
};