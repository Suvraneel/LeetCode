class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        int p[n];   // potential judges
        for (int i=0; i<n; i++){
            p[i]=0;
        }
        for (int i=0; i<trust.size(); i++){
            p[trust[i][0]-1] = INT_MIN;   // eliminated from consideration
            p[trust[i][1]-1]++;   // trusted by 1 more person
        }
        for (int i=0; i<n; i++){
            if (p[i]==n-1)
                return (i+1);
        }
        return -1;
    }
};