class Solution {
    public String robotWithString(String s) {
        Stack<Character> t = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0, ptr = 0; i < n; i++) {
            char c = s.charAt(i);
            t.push(c);
            freq[c - 'a']--;
            while (ptr < 26 && freq[ptr] == 0)
                ptr++;
            while (!t.isEmpty() && t.peek() - 'a' <= ptr)
                sb.append(t.pop());
        }
        return sb.toString();
    }
}