class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        priority_queue <long long> pq;
        long long res=0;
        for(auto g: gifts)  
            pq.push(g);
        while(k--)  
            pq.push(floor(sqrt(pq.top()))), pq.pop();
        while(!pq.empty())  
            res += pq.top(), pq.pop();
        return res;
    }
};