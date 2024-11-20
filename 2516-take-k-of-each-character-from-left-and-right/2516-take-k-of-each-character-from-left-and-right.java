class Solution {
    int minMins = Integer.MAX_VALUE;

    public int takeCharacters(String s, int k) {
        int n = s.length();
        if (k == 0)
            return 0;
        int[] freq = new int[3];
        solve(s, n, k, 0, n - 1, freq);
        return minMins == Integer.MAX_VALUE ? -1 : minMins;
    }

    private void solve(String s, int n, int k, int lt, int rt, int[] freq) {
        if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {
            minMins = Math.min(minMins, n - (rt - lt + 1));
            return;
        }
        if (lt < 0 || rt >= n || lt > rt || n - (rt - lt + 1) >= minMins)
            return;
        freq[s.charAt(lt) - 'a']++;
        solve(s, n, k, lt + 1, rt, freq);
        freq[s.charAt(lt) - 'a']--;
        freq[s.charAt(rt) - 'a']++;
        solve(s, n, k, lt, rt - 1, freq);
        freq[s.charAt(rt) - 'a']--;
    }

}