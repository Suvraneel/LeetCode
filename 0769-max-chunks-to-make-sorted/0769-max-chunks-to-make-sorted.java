class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, lt = 0, ct = 0;
        boolean[] seen = new boolean[n];
        for(int i=0; i<n; i++){
            seen[arr[i]] = true;
            while(lt<n && seen[lt])
                lt++;
            if(lt==i+1)
                ct++;
        }
        return ct;
    }
}