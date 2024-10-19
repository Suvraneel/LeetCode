class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            char[] cs = sb.reverse().toString().toCharArray();
            for (int j = 0; j < cs.length; j++)
                cs[j] = cs[j] == '0' ? '1' : '0';
            sb.reverse();
            sb.append("1" + new String(cs));
            // System.out.println(sb.toString());
        }
        return sb.charAt(k - 1);
    }
}