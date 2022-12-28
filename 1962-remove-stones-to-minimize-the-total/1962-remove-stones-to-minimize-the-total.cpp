class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        priority_queue<int> pq;
        int res = 0;
        for(int i=0; i<piles.size(); i++){
            res+=piles[i];
            pq.push(piles[i]);
        }
        while(k--){
            int p = pq.top();
            pq.pop();
            res -= floor(p/2);
            p -= floor(p/2);
            pq.push(p);
        }
        return res;
    }
};