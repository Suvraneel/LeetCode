class Solution {
    public long countOfSubstrings(String word, int k) {
        int n = word.length(), lt = 0, rt = 0, con = 0, a = 0, e = 0, i = 0, o = 0, u = 0;
        long ans = 0;
        for (; rt < n; rt++) {
            switch (word.charAt(rt)) {
                case 'a' -> a++;
                case 'e' -> e++;
                case 'i' -> i++;
                case 'o' -> o++;
                case 'u' -> u++;
                default -> con++;
            }
            // System.out.println("" + con + a + e + i + o + u);
            while (con > k) {
                switch (word.charAt(lt++)) {
                    case 'a' -> a--;
                    case 'e' -> e--;
                    case 'i' -> i--;
                    case 'o' -> o--;
                    case 'u' -> u--;
                    default -> con--;
                }
            }
            if (con == k && a > 0 && e > 0 && i > 0 && o > 0 && u > 0)
                ans++;
        }
        return ans;
    }
}