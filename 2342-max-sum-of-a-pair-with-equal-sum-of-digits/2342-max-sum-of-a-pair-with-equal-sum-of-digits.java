class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> sumOfDigits = new HashMap<>();
        for(int i: nums){
            int sum = findSumOfDigits(i);
            if(sumOfDigits.containsKey(sum))
                ans = Math.max(ans, sumOfDigits.get(sum) + i);
            sumOfDigits.put(sum, Math.max(sumOfDigits.getOrDefault(sum, 0), i));
        }
        return ans;
    }
    private int findSumOfDigits(int i){
        int sum = 0;
        while(i>0){
            sum += i%10;
            i/=10;
        }
        return sum;
    }
}