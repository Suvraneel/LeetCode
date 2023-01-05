class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        array <int, 60> v;
        for ( int i=0; i<60; i++){
            v[i] = 0;
        }
        int res = 0;
        for ( int i=0; i<time.size(); i++){
            v[time[i]%60] += 1;
        }
        for ( int i=1; i<=29; i++){
            if (!(v[i]))
                continue;
            res += v[i] * v[60-i];
            cout << res;
        }
        res += ((v[0]*(v[0]-1))/2 + (v[30]*(v[30]-1))/2);
        cout << v[30];
        return res;
    }
};