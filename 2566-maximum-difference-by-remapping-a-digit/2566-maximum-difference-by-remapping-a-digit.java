class Solution {
    public int minMaxDifference(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int min = 0, max = 0, k = 0;
        char maxReplace = 'z', minReplace = cs[0];
        for (int i = 0; i < cs.length; i++)
            min = cs[i] == minReplace ? min * 10 : min * 10 + cs[i] - '0';
        for (; k < cs.length && cs[k] == '9'; k++)
            ;
        if (k == cs.length) // max already found
            return num - min;
        maxReplace = cs[k];
        for (int i = 0; i < cs.length; i++)
            max = cs[i] == maxReplace ? max * 10 + 9 : max * 10 + cs[i] - '0';
        return max - min;
    }
}