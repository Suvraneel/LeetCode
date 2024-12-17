class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                pq.offer(new int[] { i, freq[i] });
        int[] pending = null;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (pending != null) {
                sb.append((char) (top[0] + 'a'));
                top[1]--;
                if (top[1] > 0)
                    pq.offer(top);
                top = pending;
            }
            if (top[1] > repeatLimit) {
                top[1] -= repeatLimit;
                sb.append(String.valueOf((char) (top[0] + 'a')).repeat(repeatLimit));
                pending = top;
            } else
                sb.append(String.valueOf((char) (top[0] + 'a')).repeat(top[1]));
        }
        if (pending != null && sb.charAt(sb.length() - 1) - 'a' != pending[0])
            sb.append(String.valueOf((char) (pending[0] + 'a')).repeat(Math.min(repeatLimit, pending[1])));
        return sb.toString();
    }
}