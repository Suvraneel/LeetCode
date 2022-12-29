class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        for(int i=0; i<tasks.size(); i++)
            tasks[i].push_back(i);  // emplace idx to keep PIDs intact
        sort(tasks.begin(), tasks.end());
        priority_queue <vector<int>, vector<vector<int>>, greater<vector<int>> > pq;    // burst times
        vector<int> res;
        long i=0, t=0, next_at=tasks[0][0];   // t = time elapsed
        while(i<tasks.size()){
            if(t<next_at){
                if(pq.empty())
                    t=next_at;  // next arrival time
                else{
                    t+=pq.top()[0];
                    res.push_back(pq.top()[1]);
                    pq.pop();
                }
            }
            while(t>=next_at){
                pq.push({tasks[i][1],tasks[i][2]});
                i++;
                if(i==tasks.size())
                    break;
                next_at = tasks[i][0];
            }
        }
        while(!pq.empty()){
            t+=(long)pq.top()[1];
            res.push_back(pq.top()[1]);
            pq.pop();
        }
        return res;
    }
};