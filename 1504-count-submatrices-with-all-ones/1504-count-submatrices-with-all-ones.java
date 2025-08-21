class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[] ht = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                ht[j] = mat[i][j] == 0 ? 0 : ht[j] + 1;
            Stack<int[]> monoStk = new Stack<>();
            monoStk.push(new int[]{-1, 0});  // col num, cur dp val
            for(int j=0; j<n; j++){
                while(monoStk.peek()[0]>=0 && ht[monoStk.peek()[0]]>=ht[j])
                    monoStk.pop();  // curr ht is  the limiting constraint so remove others that are deeper
                int[] top = monoStk.peek();
                int shorterJ = top[0], curr = top[1] + (j - shorterJ) * ht[j];
                monoStk.push(new int[]{j, curr});
                res += curr;
            }
        }
        return res;
    }
}