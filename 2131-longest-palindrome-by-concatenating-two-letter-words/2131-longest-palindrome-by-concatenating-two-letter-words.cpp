class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        int res=0;
        vector<string> symm;
        unordered_map <string, int> m;
        for(auto w: words){
            string rev=w;
            reverse(rev.begin(), rev.end());
            if(m[rev])  // reverse found
                m[rev]--, res+=4;
            else {
                m[w]++; // No reverse occurance
                if(rev==w)  // check if potential symm pt
                    symm.push_back(w);
            }
        }
        // find a single unpaired symmetry pt
        for(auto e: symm)
            if(m[e])
                return res+2;
        return res;
    }
};