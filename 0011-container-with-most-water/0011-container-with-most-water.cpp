class Solution {
public:
    int maxArea(vector<int>& ht) {
        int maxm=0, lt=0, rt=ht.size()-1;
        while(lt<rt){
            maxm = max(maxm, (rt-lt)*min(ht[lt], ht[rt]));
            ht[lt]<ht[rt]?lt++:rt--;
        }
        return maxm;
    }
};