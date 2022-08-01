class Solution {
public:
    #define mp make_pair
    map <pair<int, int>, int> memo;
    int uniquePaths(int m, int n) {
        if(!m || !n) return 0;
        if (m==1 && n==1){
            return 1;
        }
        if(!memo[mp(m-1, n)])
            memo[mp(m-1, n)] = uniquePaths(m-1, n);
        if(!memo[mp(m, n-1)])
            memo[mp(m, n-1)] = uniquePaths(m, n-1);
        return memo[mp(m-1, n)] + memo[mp(m, n-1)];
    }
};