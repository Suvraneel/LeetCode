class Solution {
public:
    string frequencySort(string s) {
        vector<string> v(10+26+26,"");
        for(auto c:s)
            if(c<='z' && c>='a')
                v[c-'a'+10]+=c;
            else if(c<='Z' && c>='A')
                v[c-'A'+36]+=c;
            else v[c-'0']+=c;
        sort(v.begin(), v.end(), [](string a, string b){return a.size()>b.size();});
        string res="";
        for(auto x:v)
            res+=x;
        return res;
    }
};