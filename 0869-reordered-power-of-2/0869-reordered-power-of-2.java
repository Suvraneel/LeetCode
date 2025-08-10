class Solution {
    boolean valid = false;

    public boolean reorderedPowerOf2(int n) {
        int len = 0;
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
            len++;
        }
        for (int i = 1; i < 10; i++) {
            if (freq[i] == 0)
                continue;
            freq[i]--;
            dfs(freq, i, len - 1);
            freq[i]++;
        }
        return valid;
    }

    private void dfs(int[] freq, int curr, int len) {
        if (valid)
            return;
        if (len == 0) {
            // System.out.println(curr);
            valid |= isPowerOf2(curr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (freq[i] == 0)
                continue;
            freq[i]--;
            dfs(freq, 10 * curr + i, len - 1);
            freq[i]++;
        }
    }

    private boolean isPowerOf2(int x) {
        while (x > 0) {
            if (x % 2 == 1)
                return x == 1;
            x = x >> 1;
        }
        return false;
    }
}