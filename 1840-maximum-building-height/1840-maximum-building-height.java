class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int r = restrictions.length, maxm = 0, dist;
        if (r == 0)
            return n - 1;
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int[] sentinelLt = { 1, 0 };
        int[] sentinelRt = restrictions[r - 1][0] == n // if upper bound for last building is given
                ? restrictions[r - 1] // then, use it
                : new int[] { n, n - 1 }; // else, initialize to sentinel node (rightmost)
        int[] prev = sentinelLt; // initialize to sentinel node (leftmost)
        for (int i = 0; i < r; i++) {
            dist = restrictions[i][0] - prev[0];
            restrictions[i][1] = Math.min(restrictions[i][1], prev[1] + dist);
            prev = restrictions[i];
        }
        dist = sentinelRt[0] - restrictions[r - 1][0];
        sentinelRt[1] = Math.min(sentinelRt[1], prev[1] + dist);
        prev = sentinelRt;
        for (int i = r - 1; i >= 0; i--) {
            dist = prev[0] - restrictions[i][0];
            restrictions[i][1] = Math.min(restrictions[i][1], prev[1] + dist);
            prev = restrictions[i];
        }
        prev = sentinelLt;
        for (int i = 0; i < r; i++) {
            dist = restrictions[i][0] - prev[0];
            maxm = Math.max(maxm, (prev[1] + restrictions[i][1] + dist) / 2);
            prev = restrictions[i];
        }
        if (restrictions[r - 1][0] != n) {
            dist = n - restrictions[r - 1][0];
            maxm = Math.max(maxm, (sentinelRt[1] + restrictions[r - 1][1] + dist) / 2);
        }
        // for (int[] res : restrictions)
        //     System.out.print(Arrays.toString(res) + "->");
        return maxm;
    }
}