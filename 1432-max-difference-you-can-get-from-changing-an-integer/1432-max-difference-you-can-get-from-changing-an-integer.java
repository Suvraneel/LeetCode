class Solution {
    public int maxDiff(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        char k = 'k', l = 'l';
        int max = 0, min = 0;
        for (int i = 0; i < cs.length; i++) {
            max *= 10;
            if (k == 'k' && cs[i] != '9') {
                k = cs[i];
                max += 9;
            } else if (cs[i] == k)
                max += 9;
            else
                max += cs[i] - '0';
        }
        if (cs[0] == '1') {
            for (int i = 0; i < cs.length; i++) {
                min *= 10;
                if (l == 'l' && cs[i] != '1' && cs[i] != '0') {
                    l = cs[i];
                    // min += 0;
                } else if (cs[i] == l)
                    ; // min += 0;
                else
                    min += cs[i] - '0';
            }
        } else {
            l = cs[0];
            for (int i = 0; i < cs.length; i++) {
                min *= 10;
                if (cs[i] == l)
                    min += 1;
                else
                    min += cs[i] - '0';
            }
        }
        // System.out.println(max + "\t" + min);
        return max - min;
    }
}