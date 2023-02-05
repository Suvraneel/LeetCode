class Solution {
public:
    vector<char> vowels = { 'a', 'e', 'i', 'o', 'u'};
    bool isVowelString(string s){
        int c=0;
        for(auto v:vowels){
            if(v==s.front()) c++;
            if(v==s.back()) c++;
        }
        return c==2;
    }
    
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<int> v = {0};
        for(auto w:words)
            v.push_back(isVowelString(w)?1:0);
        for(int i=1; i<v.size(); i++)
            v[i] += v[i-1];
        v.push_back(v.back());
        vector<int> ans;
        for(auto q: queries)
            ans.push_back(v[q[1]+1]-v[q[0]]);
        return ans;
    }
};