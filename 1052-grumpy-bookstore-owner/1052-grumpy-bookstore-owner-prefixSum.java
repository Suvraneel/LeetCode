class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, happyCustomers = 0;
        int[] customersLost = new int[n];
        for(int i=0; i<n; i++){
            happyCustomers += customers[i] * (1-grumpy[i]);
            customersLost[i] = customers[i] * grumpy[i];
        }
        for(int i=1; i<n; i++)
            customersLost[i] += customersLost[i-1];
        int maxCustomersLost = customersLost[minutes-1];
        for(int i=minutes; i<n; i++)
            maxCustomersLost = Math.max(maxCustomersLost, 
                customersLost[i]-customersLost[i-minutes]);
        return happyCustomers + maxCustomersLost;
    }
}
