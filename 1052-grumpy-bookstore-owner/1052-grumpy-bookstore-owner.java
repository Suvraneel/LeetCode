class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, happyCustomers = 0;
        for(int i=0; i<n; i++){
            happyCustomers += customers[i] * (1-grumpy[i]);
            customers[i] *= grumpy[i];
        }
        int slidingWindow = 0;
        for(int i=0; i<minutes; i++)
            slidingWindow += customers[i];
        int maxCustomersLostStreak = slidingWindow;
        for(int i=minutes; i<n; i++)
            maxCustomersLostStreak = Math.max(maxCustomersLostStreak, 
                (slidingWindow += customers[i] - customers[i-minutes]));
        return happyCustomers + maxCustomersLostStreak;
    }
}