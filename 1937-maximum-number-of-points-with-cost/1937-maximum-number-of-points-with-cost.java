class Solution {
    public long maxPoints(int[][] points) {
        int cols = points[0].length;
        long[] prevRow = new long[cols], currRow = new long[cols];
        for(int[] row: points){
            long runningMax = 0;
            for(int j=0; j<cols; j++)
                currRow[j] = runningMax = Math.max(runningMax-1, prevRow[j]);    // runningMax had best outcome until `j-1`th column 
                // since `j` col element can only be 1 less than runningMax due 1 extra penalty from all left prevRow elems
                // so either `runningMax-1` or if directly above elem is selected then `prevRow[j]` 
                // (which was not considered in runningMax bcz it does not fall within j-1 elems on prevRow) 
            runningMax = 0; // same as above but for elems on the right
            for(int j=cols-1; j>=0; j--)
                currRow[j] = Math.max(runningMax = Math.max(runningMax-1, prevRow[j]), currRow[j])+row[j];
            prevRow = currRow;
        }
        long ans = 0;
        for(int j=0; j<cols; j++)
            ans = Math.max(ans, prevRow[j]);
        return ans;
    }
}