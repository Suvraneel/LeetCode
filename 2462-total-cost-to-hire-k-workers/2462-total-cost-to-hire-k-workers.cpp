class Solution {
public:
    struct cmp{
        bool operator()(pair<int, bool> a, pair<int, bool> b){
            if(a.first==b.first)
                return b.second;
            return a.first>b.first;
        }
    };
    long long totalCost(vector<int>& costs, int k, int candidates) {
        long long int res=0;
        priority_queue <pair<int, bool>, vector<pair<int, bool>>, cmp> pq;    // {cost, fromLt}
        bool complete = false;
        int lt=0, rt=costs.size()-1;
        for(; lt<candidates; lt++)
            pq.push({costs[lt], true});
        for(; rt>lt && rt>costs.size()-1-candidates; rt--)
            pq.push({costs[rt], false});
        if(rt<lt)  complete = true;
        while(k--){
            auto curr = pq.top();
            pq.pop();
            res+= curr.first;
            if(complete)
                continue;
            curr.second? pq.push({costs[lt++], true}): pq.push({costs[rt--], false});
            if(rt<lt)  complete = true;
        }
        return res;
    }
};