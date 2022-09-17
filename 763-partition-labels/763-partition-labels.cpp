class Solution {
public:
    vector<int> partitionLabels(string s) {
        map <char, int> m;
        vector <int> v;
        for(int i=0; i<s.size(); i++)
            m[s[i]]=i;
        int idx=m[s[0]], prev=-1;
        for(int i=0; i<s.size(); i++)
            if(i==idx){
                v.push_back(idx-prev);
                prev = idx;
                idx = i<s.size()-1 ? m[s[i+1]]:0;
            }
            else idx=max(m[s[i]], idx);
        return v;
    }
};