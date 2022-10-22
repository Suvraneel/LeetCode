class Solution {
public:
    bool yield(vector<int>& bloomDay, int harvestDay, int m, int k){
        int adjacent = 0;
        for(auto b: bloomDay){
            adjacent = b<=harvestDay ? adjacent+1: 0;
            if(adjacent==k)
                adjacent=0, m--;    // made 1 bouquet
        }
        return m<=0;    // reqd no. of bouquets done
    }
    int minDays(vector<int>& bloomDay, int m, int k) {
        if((long)bloomDay.size()<(long)m*k)
            return -1;  // only defaulter case (since, if length>=m*k, it must be valid by infinity)
        auto lt=0, rt=1000000000;
        while(lt<rt){
            auto mid = lt+(rt-lt)/2;
            if(yield(bloomDay, mid, m, k))
                 rt=mid;
            else lt=mid+1;
        }
        return lt;
    }
};