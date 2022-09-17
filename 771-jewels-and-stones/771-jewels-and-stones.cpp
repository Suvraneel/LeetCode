class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        map <char, int> m;
        int res=0;
        for (auto j:jewels)
            m[j]=1;
        for (auto s:stones)
            if (m[s])
                res++;
        return res;
    }
};