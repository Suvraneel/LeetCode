class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        bool res = true;
        vector<bool> vis(rooms.size(), false);
        queue <int> q;
        q.push(0);
        vis[0] = true;
        while(!q.empty()){
            int cur = q.front();
            for (int key: rooms[cur]){
                if(vis[key])
                    continue;
                else{
                    q.push(key);
                    vis[key] = true;
                }
            }
            q.pop();
        }
        for_each(vis.begin(), vis.end(), [&res](bool b){
            res &= b;
        });
        return res;
    }
};