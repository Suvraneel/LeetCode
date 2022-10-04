class Solution {
public:
    struct comparator{
        bool operator()(pair<int, int> a, pair<int, int> b){
            return a.first<b.first;
        }
    };
    
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        if(k==1)
            return nums;
        vector<int> res;
        priority_queue<pair<int, int>, vector<pair<int, int>>, comparator> pq;
        for(int i=0; i<k; i++)
            pq.push({nums[i], i});
        res.push_back(pq.top().first);
        for(int i=k; i<nums.size(); i++){
            while(pq.top().second<=i-k)
                pq.pop();
            pq.push({nums[i], i});
            res.push_back(pq.top().first);
        }
        return res;
    }
};