class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string a = "", b = "";
        for(auto e: word1)
            a+=e;
        for(auto e: word2)
            b+=e;
        return a==b;
    }
};