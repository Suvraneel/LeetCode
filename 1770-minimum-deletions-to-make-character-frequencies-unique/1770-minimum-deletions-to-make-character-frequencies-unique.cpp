class Solution {
public:
    int minDeletions(string s) {
        int res = 0;
        map <int, char> m1;
        map <char, int> m2;
        for(auto e: s)
            m2[e]++;
        for(auto [A, F]: m2){
            int temp = F;
            if(!m1[temp]);
            else while(m1[temp] && temp--) res++;
            m1[temp] = A;
        }
        return res;
    }
};