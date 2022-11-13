class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        string word, res="";
        vector<string> sentence;
        while(ss >> word)
            sentence.push_back(word);
        reverse(sentence.begin(), sentence.end());
        for(auto word:sentence)
            res+=word+" ";
        res.pop_back();
        return res;
    }
};