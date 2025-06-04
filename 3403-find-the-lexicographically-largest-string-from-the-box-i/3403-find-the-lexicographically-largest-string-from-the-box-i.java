class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;
        int n = word.length(), maxLen = n - numFriends + 1;
        char startChar = word.charAt(0);
        Set<Integer> startIdx = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c > startChar) {
                startIdx.clear();
                startChar = c;
                startIdx.add(i);
            } else if (c == startChar)
                startIdx.add(i);
        }
        String ans = "";
        for (int i : startIdx) {
            String w = word.substring(i, Math.min(i + maxLen, n));
            System.out.println(w);
            if (ans.compareTo(w) < 1)
                ans = w;
        }
        return ans;
    }
}