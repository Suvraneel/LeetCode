class Solution {
    public double averageWaitingTime(int[][] customers) {
        long time = 0, totalWait = 0;
        for(int[] c: customers){
            int arrival = c[0], prep = c[1];
            if(arrival>=time)
                time = arrival;
            time += prep;
            totalWait += time - arrival;
        }
        return (double)totalWait/customers.length;
    }
}