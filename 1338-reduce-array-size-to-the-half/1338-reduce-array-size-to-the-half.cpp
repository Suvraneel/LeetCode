class Solution {
public:
    int minSetSize(vector<int>& arr) {
        vector <int> v;
        map <int, int> m;
        for(auto e:arr)
            m[e]++;
        for(auto k:m)
            v.push_back(k.second);
        sort(v.begin(), v.end(), greater<int>());
        int left = arr.size(), res=0;
        while(left>arr.size()/2)
            left-=v[res++];
        return res;
    }
};