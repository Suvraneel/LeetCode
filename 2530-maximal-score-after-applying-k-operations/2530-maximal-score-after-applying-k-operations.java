class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int i: nums)
            pq.offer(i);
        long score = 0;
        for(int i=0; i<k; i++){
            int largest = pq.poll();
            score += largest;
            pq.offer((int)Math.ceil(largest/3.0));
        }
        return score;
    }
}