class Solution {
public:
    set <string> s;
    int uniqueMorseRepresentations(vector<string>& words) {
        string map[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        string token;
        for(auto w:words){
            token = "";
            for(auto letter:w)
                token+=map[letter -'a'];
            s.insert(token);
        }
        return s.size();
    }
};