class Solution {
    public int minInsertions(String s) {
        int n = s.length(), open = 0, count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if ((open & 1) == 1) { // odd open invalid, so insert a closed first{
                    count++;
                    open--;
                }
                open += 2;
            } else {
                open--;
                if (open < 0) { // cant be negative, so add an opening bracket which contributes to 2 closes.
                    open += 2;
                    count++;
                }
            }
        }
        count += open; // add closes for all opens
        return count;
    }
}