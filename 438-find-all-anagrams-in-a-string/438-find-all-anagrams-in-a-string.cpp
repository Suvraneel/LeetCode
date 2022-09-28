class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> pHash(26, 0), winHash(26, 0);
        vector<int> ans;
        if(s.length()<p.length())
            return ans;
        for(auto c: p)
            pHash[c-'a']++;
        for(int lt=0, rt=0; rt<p.length(); rt++)
            winHash[s[rt]-'a']++;
        if(winHash==pHash)
            ans.push_back(0);
        for(int lt=1, rt=p.length(); rt<s.length();lt++, rt++){
            winHash[s[lt-1]-'a']--;
            winHash[s[rt]-'a']++;
            if(winHash==pHash)
                ans.push_back(lt);
        }
        return ans;
    }
};