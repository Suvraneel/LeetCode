class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, q = queries.length;
        int[] answer = new int[q];
        for(int i=1; i<n; i++)
            arr[i] ^= arr[i-1];
        // System.out.println(Arrays.toString(arr));
        for(int i=0; i<q; i++)
            answer[i] = arr[queries[i][1]] ^ (queries[i][0]>0?arr[queries[i][0]-1]:0);
        return answer;
    }
}