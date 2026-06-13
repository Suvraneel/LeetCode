class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            int sum = 0, n = s.length();
            for (int i = 0; i < n; i++)
                sum += weights[s.charAt(i) - 'a'];
            sb.append((char) ('z' - (sum % 26)));
        }
        return sb.toString();
    }
}