class Solution {
public:
    vector<int> partitionLabels(string s) {
        map <char, int> m;
        vector <int> v;
        int i=0;
        for(auto c:s)
            m[c]=i++;
        int streak=m[s[0]], prev=-1;
        for(int i=0; i<s.size(); i++)
            if(i==streak){
                v.push_back(streak-prev);
                prev = streak;
                streak = i<s.size()-1 ? m[s[i+1]]:0;
            }
            else streak=max(m[s[i]], streak);
        return v;
    }
};