class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_map <int, int> m;
        vector<int> v;
        for(auto n:nums1)
            m[n]=1;
        for(auto n:nums2)
            if(m[n])
                v.push_back(n), m[n]--;
        return v;
    }
};