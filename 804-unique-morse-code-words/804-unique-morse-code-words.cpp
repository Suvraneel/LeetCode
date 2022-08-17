class Solution {
public:
    set <string> s;
    int uniqueMorseRepresentations(vector<string>& words) {
        string map[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(auto w:words){
            string token = "";
            for(auto letter:w)
                token+=map[letter -'a'];
            s.insert(token);
        }
        return s.size();
    }
};