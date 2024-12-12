class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        long total = 0;
        for(int g: gifts){
            pq.offer(g);
            total += g;
        }
        for(int i=0; i<k; i++){
            int top = pq.poll();
            int newVal = (int)Math.sqrt(top);
            total -= top - newVal;
            pq.offer(newVal);
        }
        return total;
    }
}