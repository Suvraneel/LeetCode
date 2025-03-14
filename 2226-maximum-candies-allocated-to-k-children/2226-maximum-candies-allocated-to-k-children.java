class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        if(candies.length >= k)
            return candies[0];
        int n = candies.length, lt = 1, rt = candies[0], ans = 0;
        while(lt<=rt){
            int mid = (lt + rt) / 2;
            if(isValidDistrib(candies, n, k, mid)){
                ans = mid;
                lt = mid + 1;
            } else 
                rt = mid - 1;
        }
        return ans;
    }
    private boolean isValidDistrib(int[] candies, int n, long k, int c){
        long fed = n;
        for(int i=n-1; i>=0; i--){
            int extra = candies[i] / c - 1;
            fed += extra;
            if(fed >= k)
                return true;
            if(extra == 0)
                return false;
        }
        return false;
    }
}