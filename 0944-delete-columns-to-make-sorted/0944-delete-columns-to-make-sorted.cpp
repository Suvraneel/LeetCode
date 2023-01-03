class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int res = 0;
        vector<char> cols(strs[0].size(),'a');
        vector<bool> del(strs[0].size(), false);
        for(auto s:strs){
            for(int i=0; i<cols.size();i++){
                if(del[i])
                    continue;
                if(cols[i]>s[i]){
                    res++;
                    del[i]=true;
                }
                cols[i]=s[i];
            }
        }
        return res;
    }
};