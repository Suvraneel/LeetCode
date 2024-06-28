class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for(int[] edge: roads){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Arrays.sort(degree);
        long imp = 0;
        for(int i=0; i<n; i++)
            imp += degree[i] * (i+1);
        return imp;
    }
}