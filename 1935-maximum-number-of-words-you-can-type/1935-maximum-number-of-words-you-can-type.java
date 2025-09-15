class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        next: for (String w : words) {
            for (char c : w.toCharArray())
                if (brokenLetters.indexOf(c) != -1)
                    continue next;
            count++;
        }
        return count;
    }
}