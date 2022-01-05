class Solution {
public:
    vector<vector<string>> partition(string s) {
        int len = s.length();
        vector<vector<bool>> dp (len, vector<bool>(len, false));
        vector <vector<string>> res;
        vector<string> curr;
        dfs(dp, res, s, curr, 0);
        return res;
    }
    
    void dfs(vector<vector<bool>> &dp, vector<vector<string>> &res, string &s, vector<string> &curr, int start){
        if(start>=s.length())
            res.push_back(curr);
        for(int end=start; end<s.length(); end++){
            if(s[start]==s[end] && (end-start<=2 || dp[start+1][end-1])){
                dp[start][end] = true;
                curr.push_back(s.substr(start, end-start+1));
                dfs(dp, res, s, curr, end+1);
                curr.pop_back();
            }
        }
    }
};