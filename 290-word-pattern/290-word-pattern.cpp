class Solution {
public:
    bool wordPattern(string pattern, string s) {
        unordered_map <char, string> m;
        unordered_map <string, char> n;
        stringstream ss(s);
        int i=0;
        string word;
        while (ss >> word) {
            auto a = m.find(pattern[i]);
            auto str = n.find(word);
            if(a==m.end() && str==n.end()){             // new key
                m.insert({pattern[i], word});
                n.insert({word, pattern[i]});
            }
            else if((a!=m.end() && a->second!=word) || (str!=n.end() && str->second!=pattern[i]))
                return false;
            i++;
        }
        if(i!=pattern.length())                      // check if char-word count same
            return false;
        return true;
    }
};