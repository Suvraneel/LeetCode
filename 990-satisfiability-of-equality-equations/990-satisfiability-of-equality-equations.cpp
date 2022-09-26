class Solution {
public:
    void merge(int a, int b, vector<int>& dp){
        for(int i=0; i<26; i++)
            if(dp[i]==b)
                dp[i]=a;
    }
    
    bool equationsPossible(vector<string>& equations) {
        vector<int> dp(26, 0);
        vector<string> notEqns;
        int k=1;
        for(auto eqn: equations){
            if(eqn[1]=='!'){
                notEqns.push_back(eqn);
                continue;
            }
            int a = eqn[0]-'a', b = eqn[3]-'a';
            if(dp[a]&&dp[b])
                merge(dp[a],dp[b],dp);
            else if(dp[a]||dp[b])
                dp[a]=dp[b]=max(dp[a],dp[b]);
            else dp[a]=dp[b]=k++;
        }
        for(auto eqn: notEqns)
            if(eqn[0]==eqn[3] || (dp[eqn[0]-'a']==dp[eqn[3]-'a'] && dp[eqn[0]-'a']!=0))
                return false;
        return true;
    }
};