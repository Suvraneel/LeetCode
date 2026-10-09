class Solution {
    public int minInsertions(String s) {
        int n = s.length(), open = 0, count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if ((open & 1) == 1) { // odd n(open) invalid, so insert a closed at i first
                    count++;
                    open--;
                }
                open += 2; // 1 open needs 2 closes
            } else {
                open--;
                if (open < 0) { // n(open) cant be negative, so add 1 open somewhere before i
                    open += 2;
                    count++;
                }
            }
        }
        count += open; // add closes for all opens
        return count;
    }
}