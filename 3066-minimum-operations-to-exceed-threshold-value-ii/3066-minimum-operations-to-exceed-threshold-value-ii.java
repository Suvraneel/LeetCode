class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int n : nums)
            pq.offer(n);
        while (pq.size() >= 2 && pq.peek() < k) {
            int x = pq.poll(), y = pq.poll();
            pq.offer(x * 2 + y);
            count++;
        }
        return count;
    }
}