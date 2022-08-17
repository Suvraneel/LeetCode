class Solution {
public:
    unordered_set <string> s;
    int uniqueMorseRepresentations(vector<string>& words) {
        vector <string> v = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(auto w:words){
            string token = "";
            for(auto l:w)
                token+=v[l -'a'];
            s.insert(token);
        }
        return s.size();
    }
};