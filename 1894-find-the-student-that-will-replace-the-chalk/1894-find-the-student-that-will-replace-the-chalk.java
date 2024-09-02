class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        while(k>0){
            for(int i=0; i<n; i++){
                k -= chalk[i];
                if(k<0)
                    return i;
            }
        }
        return 0;
    }
}