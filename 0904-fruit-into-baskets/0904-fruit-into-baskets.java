class Solution {
    public int totalFruit(int[] fruits) {
        int prev = -1, count = 0, maxCount = 0;
        int[] types = new int[2];
        int[] streak = new int[2];
        for(int f: fruits){
            if(types[0] == f){
                streak[0]++;
                streak[1] = 0;
                count++;
            } else if(types[1] == f){
                streak[1]++;
                streak[0] = 0;
                count++;
            } else {
                if(streak[0] == 0){
                    types[0] = f;
                    streak[0] = 1;
                    count = streak[1] + 1;
                    streak[1] = 0;
                } else if (streak[1] == 0) {
                    types[1] = f;
                    streak[1] = 1;
                    count = streak[0] + 1;
                    streak[0] = 0;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}