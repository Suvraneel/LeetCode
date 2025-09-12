class Solution {
    public boolean doesAliceWin(String s) {
        // If num of vowels in s is odd, Alice removes entire s & takes the win
        // If num of vowels in s is zero, Alice cant make a move & so Bob wins
        /** If num of vowels in s is even but not zero, Alice will rm odd num of chars (ie, vowelCt - 1),
        * Bob may lose in round 1 if no consonants left, 
        * else he will lose in round 2 when Alice rms the remaining vowel
        */
        // So, in a nutshell, Alice can only lose when no. of vowels in s is exactly zero.
        for(char c: s.toCharArray())
            if("aeiou".indexOf(c)!=-1)
                return true;
        return false;
    }
}