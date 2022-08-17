class Solution {
public:
    set <string> s;
    int uniqueMorseRepresentations(vector<string>& words) {
        string a[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(auto w:words){
            string token = "";
            for(int i=0; i<w.length(); i++)
                token+=a[w[i]-'a'];
            s.insert(token);
        }
        return s.size();
    }
};