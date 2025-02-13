class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> pq = new PriorityQueue<>();
        int count = 0;
        for (int n : nums)
            pq.offer((long) n);
        while (pq.size() >= 2 && pq.peek() < k) {
            long x = pq.poll(), y = pq.poll();
            pq.offer(x * 2l + y);
            count++;
        }
        return count;
    }
}