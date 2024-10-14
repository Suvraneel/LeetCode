class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i : nums)
            pq.offer(i);
        long score = 0;
        while (k-- > 0) {
            int largest = pq.poll();
            score += largest;
            pq.offer((int) Math.ceil(largest / 3.0));
        }
        return score;
    }
}