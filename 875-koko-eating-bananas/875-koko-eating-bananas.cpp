class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int H) {
        int lo = 1, hi = 1000000000, k = 0;
        while (lo <= hi) {
            k = (lo + hi) / 2;
            int h = 0;
            for (int i = 0; i < piles.size(); i ++) 
                h += ceil(1.0 * piles[i] / k);
            if (h > H)
                lo = k + 1;
            else
                hi = k - 1;
        }
        return lo;
    }
};