class Solution {
    public String clearStars(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            if (cs[i] == '*')
                cs[pq.poll()[1]] = '*';
            else
                pq.offer(new int[] { cs[i] - 'a', i });
        }
        return new String(cs).replace("*", "");
    }
}