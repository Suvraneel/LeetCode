class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        int len = 1;
        while (len < k) {
            for (int i = 0; i < len; i++)
                sb.append((char) (((sb.charAt(i) - 'a' + 1) % 26) + 'a'));
            len = sb.length();
        }
        System.out.println(sb);
        return sb.charAt(k - 1);
    }
}