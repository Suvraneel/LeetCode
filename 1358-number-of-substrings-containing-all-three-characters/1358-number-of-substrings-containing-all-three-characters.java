class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), lt = 0, rt = 0, ans = 0;
        int[] freq = new int[3];
        while (rt < n) {
            freq[s.charAt(rt) - 'a']++;
            while (valid(freq)) {
                ans += n - rt;
                freq[s.charAt(lt++) - 'a']--;
            }
            rt++;
        }
        return ans;
    }

    boolean valid(int[] freq) {
        return Math.min(Math.min(freq[0], freq[1]), freq[2]) > 0;
    }
}