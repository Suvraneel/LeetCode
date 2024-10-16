class Solution {
    private record Node(int freq, char ch) {
    }

    public String longestDiverseString(int... args) {
        Queue<Node> pq = new PriorityQueue<>((m, n) -> n.freq - m.freq);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            if (args[i] > 0)
                pq.offer(new Node(args[i], (char) ('a' + i)));
        Node top = pq.poll();
        while (top != null) {
            int f = top.freq, k = !pq.isEmpty() && pq.peek().freq >= f * 2 ? 1 : 2;
            char ch = top.ch;
            while (f > 0 && k-- > 0) {
                sb.append(ch);
                f--;
            }
            // System.out.println(pq);
            if (pq.isEmpty())
                break;
            top = pq.poll();
            if (f > 0)
                pq.offer(new Node(f, ch));
        }
        return sb.toString();
    }
}