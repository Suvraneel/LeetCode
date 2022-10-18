class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        map <char, bool> m;
        int res=0;
        for (auto j:jewels)
            m[j]=true;
        for (auto s:stones)
            if (m[s])
                res++;
        return res;
    }
};