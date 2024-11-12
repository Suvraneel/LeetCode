class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int maxBeauty = 0, m = items.length, n = queries.length;
        int[][] queriesWithIdx = new int[n][2];
        for (int j = 0; j < n; j++)
            queriesWithIdx[j] = new int[] { queries[j], j };
        Arrays.sort(queriesWithIdx, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        for (int i = 0, j = 0; j < n; j++) {
            int[] q = queriesWithIdx[j];
            while (i < m && q[0] >= items[i][0])
                maxBeauty = Math.max(maxBeauty, items[i++][1]);
            ans[q[1]] = maxBeauty;
            // System.out.println(q[0] + "\t" + q[1] + "\t" + maxBeauty);
        }
        return ans;
    }
}