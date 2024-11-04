class Solution {
    public String compressedString(String word) {
        word += '.'; // EOF
        StringBuilder sb = new StringBuilder();
        char prev = word.charAt(0);
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (count == 9 || c != prev) {
                sb.append(count).append(prev);
                prev = c;
                count = 1;
            } else
                count++;
        }
        return sb.toString();
    }
}