class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        String prev = words[words.length - 1];
        for (String w : words) {
            if (w.charAt(0) != prev.charAt(prev.length() - 1))
                return false;
            prev = w;
        }
        return true;
    }
}