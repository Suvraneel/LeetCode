class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingDouble(e -> (double) e.getKey() / e.getValue()));
        IntStream.range(0, arr.length).forEach(i -> IntStream.range(i + 1, arr.length)
                .forEach(j -> pq.offer(new java.util.AbstractMap.SimpleEntry<>(arr[i], arr[j]))));
        IntStream.range(0, k - 1).forEach(x -> pq.poll());
        int[] ans = new int[2];
        var m = pq.poll();
        ans[0] = m.getKey();
        ans[1] = m.getValue();
        return ans;
    }
}