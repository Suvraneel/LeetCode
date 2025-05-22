class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        int n = nums.length, q = queries.length, ops = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // to store useful queries (larger ranged ones preffered, smaller ones ignored unless mandatory)
        int[] deltaArr = new int[n + 1];
        for (int i = 0, j = 0; i < n; i++) {
            ops += deltaArr[i];
            while (j < q && queries[j][0] == i) {
                maxHeap.offer(queries[j][1]);
                j++;
            }
            while (ops < nums[i] && !maxHeap.isEmpty() && maxHeap.peek() >= i) {
                ops++;
                deltaArr[maxHeap.poll() + 1]--;
            }
            if (ops < nums[i])
                return -1;
        }
        return maxHeap.size();
    }
}