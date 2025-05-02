class Solution {
    public String pushDominoes(String dominoes) {
        char[] ans = dominoes.toCharArray();
        int n = dominoes.length(), count = 0, prevIdx = -1;
        char prev = 'L';
        for (int i = 0; i < n; i++) {
            if (ans[i] == '.')
                continue;
            else if (ans[i] == prev) {
                for (int j = i - 1; j > prevIdx; j--)
                    ans[j] = prev;
                prevIdx = i;
            } else {
                if (prev == 'R') {
                    for (int j = 1; j <= (i - prevIdx - 1) / 2; j++) {
                        ans[prevIdx + j] = 'R';
                        ans[i - j] = 'L';
                    }
                }
                prev = ans[i];
                prevIdx = i;
            }
        }
        if (prev == 'R')
            for (int j = prevIdx + 1; j < n; j++)
                ans[j] = 'R';
        return new String(ans);
    }
}