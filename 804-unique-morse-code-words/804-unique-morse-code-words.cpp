class Solution {
public:
    unordered_set <string> s;int uniqueMorseRepresentations(vector<string>& words) {string a[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};for(auto w:words){string token = "";for(auto l:w)token+=a[l-'a'];s.insert(token);}return s.size();
    }
};