class Solution {
    private record Node(int freq, char ch) {
    }

    public String longestDiverseString(int a, int b, int c) {
        Queue<Node> pq = new PriorityQueue<>((m, n) -> n.freq - m.freq);
        if(a==0 && b==0 && c==0)
            return "";
        StringBuilder sb = new StringBuilder();
        if (a > 0)
            pq.offer(new Node(a, 'a'));
        if (b > 0)
            pq.offer(new Node(b, 'b'));
        if (c > 0)
            pq.offer(new Node(c, 'c'));
        Node top = pq.poll();
        while (top!=null) {
            int f = top.freq, k = !pq.isEmpty() && pq.peek().freq>f ? 1 : 2;
            char ch = top.ch;
            while (f > 0 && k-- > 0) {
                sb.append(ch);
                f--;
            }
            System.out.println(pq);
            if(pq.isEmpty())
                break;
            top = pq.poll();
            if (f > 0) 
                pq.offer(new Node(f, ch));
        }
        return sb.toString();
    }
}