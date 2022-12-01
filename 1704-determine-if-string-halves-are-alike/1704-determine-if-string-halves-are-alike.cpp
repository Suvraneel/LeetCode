class Solution {
public:
    bool halvesAreAlike(string s) {
        unordered_set <char> vowel = {'a','e','i','o','u','A','E','I','O','U'};
        int last = s.size()-1, half=s.size()/2, ctA=0, ctB=0;
        for(int i=0; i<half; i++){
            if(vowel.find(s[i])!=vowel.end())
                ctA++;
            if(vowel.find(s[last-i])!=vowel.end())
                ctB++;
        }
        return ctA==ctB;
    }
};