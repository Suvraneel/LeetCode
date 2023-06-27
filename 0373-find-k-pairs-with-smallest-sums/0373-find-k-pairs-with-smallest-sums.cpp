class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int i=0, j=0;
        vector<vector<int>> v;
        auto comparator = [](const vector<int>& a, const vector<int>& b){
            return a[0]+a[1]<b[0]+b[1];
        };
        int maxI = min(k, static_cast<int>(nums1.size()));
        int maxJ = min(k, static_cast<int>(nums2.size()));
        priority_queue <vector<int>, vector<vector<int>>, decltype(comparator)> pq(comparator);
        for(int i=0; i<maxI; i++){
            for(int j=0; j<maxJ; j++){
                if(pq.size()<k)
                    pq.push({nums1[i], nums2[j]});
                else{ //(pq.size()>k)
                    if(nums1[i]+nums2[j]<pq.top()[0]+pq.top()[1])
                        pq.pop(), pq.push({nums1[i], nums2[j]});
                    else break;
                }
            }
        }
        while(k-- && !pq.empty())
            v.push_back(pq.top()), pq.pop();
        reverse(v.begin(), v.end());
        return v;
    }
};