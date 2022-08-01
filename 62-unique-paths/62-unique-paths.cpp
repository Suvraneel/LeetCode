class Solution {
public:
    map <pair<int, int>, int> memo;
    int uniquePaths(int m, int n) {
        if(!m || !n) return 0;
        if (m==1 && n==1){
            return 1;
        }
        int a = memo[{m-1, n}] ? memo[{m-1, n}] : uniquePaths(m-1, n);
        memo[{m-1, n}] = a;
        int b = memo[{m, n-1}] ? memo[{m, n-1}] : uniquePaths(m, n-1);
        memo[{m, n-1}] = b;
        return a+b;
    }
};