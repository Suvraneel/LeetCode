class Solution {
public:
    struct comparator{
      bool operator()(pair<string, int> a, pair<string, int> b){
          return a.second!=b.second?a.second<b.second:a.first>b.first;
      } // reverse sort by freq... if same ascending sort lexically  
    };
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map <string, int> m;
        for(string s: words)
            m[s]++;
        priority_queue <pair<string, int>, vector<pair<string, int>>, comparator> pq;
        for(auto [k, v]: m)
            pq.push(make_pair(k, v));
        vector <string> v;
        while(!pq.empty() && k--)
            v.push_back(pq.top().first), pq.pop();
        return v;
    }
};