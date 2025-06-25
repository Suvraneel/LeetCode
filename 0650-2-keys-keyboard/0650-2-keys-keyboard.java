class Solution {
    public int minSteps(int n) {
        int[] minOps = new int[n + 1];
        Arrays.fill(minOps, n + 1);
        minOps[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++)
                if (i % j == 0)
                    minOps[i] = Math.min(minOps[i], minOps[j] + i / j);
        }
        // System.out.println(Arrays.toString(minOps));
        return minOps[n];
    }
}