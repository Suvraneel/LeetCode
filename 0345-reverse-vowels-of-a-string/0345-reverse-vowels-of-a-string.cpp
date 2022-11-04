class Solution {
public:
    string reverseVowels(string s) {
        int lt=0, rt=s.size()-1;
        unordered_set<char> vowel = {'a','e','i','o','u','A','E','I','O','U'};
        while (lt<rt){
            while(lt<rt && vowel.find(s[lt])==vowel.end())   lt++;
            while(lt<rt && vowel.find(s[rt])==vowel.end())   rt--;
            if(lt<rt)   swap(s[lt], s[rt]);
            lt++, rt--;
        }
        return s;
    }
};