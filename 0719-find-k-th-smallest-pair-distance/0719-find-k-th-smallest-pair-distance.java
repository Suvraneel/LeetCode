class Solution {
    private class FixedBufferPQ {

        int k; // Fixed size of buffer
        Queue<Integer> pq;

        public FixedBufferPQ(int k) {
            this.k = k;
            pq = new PriorityQueue<>((a, b) -> b - a);
        }

        public boolean add(int x) {
            if (pq.size() == k) {
                if (x > pq.peek())
                    return true;
                pq.poll();
            }
            pq.offer(x);
            return false;
        }

        public int top() {
            if (pq.isEmpty())
                return -1;
            return pq.peek();
        }
    }

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        FixedBufferPQ fpq = new FixedBufferPQ(k);
        for (int step = 1; step < n; step++)
            for (int i = 0; i < n - step; i++)
                if (fpq.add(nums[i + step] - nums[i])) {
                    step++;
                    i = 0;
                }
        return fpq.top();
    }
}