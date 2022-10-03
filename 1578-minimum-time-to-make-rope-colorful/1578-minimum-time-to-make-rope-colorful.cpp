class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        int res=0;
        for(int i=1, j=0; i<colors.length(); i++)
            if(colors[i]==colors[j]){
                if(neededTime[j]>neededTime[i])
                    res+=neededTime[i]; // j=j
                else res+=neededTime[j], j=i;
            } else j=i;
        return res;
    }
};