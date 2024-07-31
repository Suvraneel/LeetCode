class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer[][] dp = new Integer[books.length][shelfWidth + 1];
        return solve(shelfWidth, books, dp, 0, shelfWidth, 0);
    }

    private int solve(int shelfWidth, int[][]books, Integer[][] dp, int i, int cap, int maxHt) {
        if(i==books.length)
            return maxHt;
        int[] curr = books[i];
        if(dp[i][cap]!=null)
            return dp[i][cap];
        int htSameShelf = Integer.MAX_VALUE, htNewShelf;
        htNewShelf = maxHt 
            + solve(shelfWidth, books, dp, i+1, shelfWidth-curr[0], curr[1]);
        if(cap>=curr[0]){
            htSameShelf = solve(shelfWidth, books, dp, i+1, cap-curr[0], 
            Math.max(maxHt, curr[1]));
        }
        return dp[i][cap] = Math.min(htNewShelf, htSameShelf);
    }
}