class Solution {
    private Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    private int vowelCount(String s){
        int count = 0;
        for(char c: s.toCharArray())
            if(vowels.contains(c))
                count++;
        return count;
    }
    public boolean doesAliceWin(String s) {
        int vowelCt = vowelCount(s);
        if(vowelCt % 2 == 1)
            return true;    // Alice removes all chars & wins
        if(vowelCt == 0)
            return false;   // Alice cant make a move & loses to Bob
        return true;
    }
}