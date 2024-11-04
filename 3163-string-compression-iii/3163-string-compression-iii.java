class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char[] cs = word.toCharArray();
        char prev = '1';
        int count = 0;
        for (char c : cs) {
            if (c == prev)
                count++;
            else {
                while (count > 9) {
                    sb.append('9');
                    sb.append(prev);
                    count -= 9;
                }
                if (count > 0) {
                    sb.append(count);
                    sb.append(prev);
                }
                prev = c;
                count = 1;
            }
        }
        while (count > 9) {
            sb.append('9');
            sb.append(prev);
            count -= 9;
        }
        if (count > 0) {
            sb.append(count);
            sb.append(prev);
        }
        return sb.toString();
    }
}