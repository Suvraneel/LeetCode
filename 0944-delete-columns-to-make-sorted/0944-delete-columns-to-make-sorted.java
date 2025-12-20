class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length(), del = 0;
        loop: for (int i = 0; i < n; i++) {
            char prev = 'a';
            for (String s : strs) {
                char curr = s.charAt(i);
                if (curr < prev) {
                    del++;
                    continue loop;
                }
                prev = curr;
            }
        }
        return del;
    }
}