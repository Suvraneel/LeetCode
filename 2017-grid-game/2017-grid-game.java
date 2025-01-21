class Solution { 
    public long gridGame(int[][] grid) {
        int m = 2, n = grid[0].length;
        long[][] prefixSum = genPrefixSum(grid, n);
        return optimalRoutePts(prefixSum, n);
    }
    private long[][] genPrefixSum(int[][] grid, int n){
        long cumSumRow1 = 0, cumSumRow2 = 0;
        long[][] prefixSum = new long[2][n+1];
        for(int j=0; j<n; j++){
            prefixSum[0][j+1] = cumSumRow1 += grid[0][j];
            prefixSum[1][j+1] = cumSumRow2 += grid[1][j];
        }
        return prefixSum;
    }
    private long optimalRoutePts(long[][] prefixSum, int n){
        long maxPtsForRobot2, minMaxPtsForRobot2 = Long.MAX_VALUE;
        for(int j=1; j<=n; j++){
            maxPtsForRobot2 = Math.max(prefixSum[0][n] - prefixSum[0][j], prefixSum[1][j-1]);
            if(maxPtsForRobot2<minMaxPtsForRobot2)
                minMaxPtsForRobot2 = Math.min(minMaxPtsForRobot2, maxPtsForRobot2);
        }
        return minMaxPtsForRobot2;
    }
}