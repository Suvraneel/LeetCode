class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> vis = new HashSet<>();
        pq.offer(1L);
        while(!pq.isEmpty()){
            long top = pq.poll();
            if(vis.contains(top))
                continue;
            vis.add(top);
            if(vis.size()==n)
                return (int)top;
            pq.offer(top*2);
            pq.offer(top*3);
            pq.offer(top*5);
        }
        return 1;
    }
}