class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int res = 0;
        vector<string> cols(strs[0].size(),"");
        for(auto s:strs)
            for(int i=0; i<cols.size();i++)
                cols[i]+=s[i];
        for(auto c:cols){
            string x = c;
            sort(x.begin(), x.end());
            if(x!=c)
                res++;
        }
        return res;
    }
};