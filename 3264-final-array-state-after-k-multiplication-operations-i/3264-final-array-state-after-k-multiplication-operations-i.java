class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0]
                ? a[1] - b[1]
                : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++)
            pq.offer(new int[] { nums[i], i });
        while (k-- > 0) {
            int[] top = pq.poll();
            top[0] *= multiplier;
            nums[top[1]] = top[0];
            pq.offer(top);
        }
        return nums;
    }
}