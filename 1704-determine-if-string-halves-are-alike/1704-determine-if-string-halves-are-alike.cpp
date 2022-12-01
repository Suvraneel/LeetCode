class Solution {
public:
    bool halvesAreAlike(string s) {
        unordered_set <char> vowel = {'a','e','i','o','u','A','E','I','O','U'};
        int len = s.size()/2, ctA=0, ctB=0;
        for(int i=0; i<len; i++)
            if(vowel.find(s[i])!=vowel.end())
                ctA++;
        for(int i=len; i<2*len; i++)
            if(vowel.find(s[i])!=vowel.end())
                ctB++;
        return ctA==ctB;
    }
};