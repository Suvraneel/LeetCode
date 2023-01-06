// class Solution {
// public:
//     int maxIceCream(vector<int>& costs, int coins) {
//         sort(costs.begin(), costs.end());
//         int i=0;
//         while (i<costs.size() && coins>=costs[i])
//             coins-=costs[i++];
//         return i;
//     }
// };

class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        vector<int> map(100001, 0);
        int i, res=0;
        for(auto c: costs)
            map[c]++;
        for(i=1; i<=min(100000, coins); i++){
            int canBuy = min(map[i], coins/i);
            coins-=canBuy*i;
            res+=canBuy;
        }
        return res;
    }
};