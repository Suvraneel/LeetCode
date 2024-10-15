class Solution {
    public long minimumSteps(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, write = 0, read = 0;
        while (write < n && cs[write] == '0')
            write++;
        if(write == n)
            return 0;
        read = write + 1;
        long steps = 0;
        while (true) {
            while (write < read && cs[write] == '0')
                write++;
            while (read < n && cs[read] != '0')
                read++;
            if (read == n)
                return steps;
            cs[write] = '0';
            cs[read] = '1';
            steps += read++ - write++;
        }
    }
}