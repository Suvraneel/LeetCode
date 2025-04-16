class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length, numPairs = 0;
        long ans = 0;
        Map<Integer, Integer> freq = new HashMap<>(); 
        for(int lt = 0, rt = -1; lt < n; lt++){
            while(numPairs<k && rt<n-1){
                rt++;
                int oldFreq = freq.getOrDefault(nums[rt], 0);
                numPairs += oldFreq;
                freq.put(nums[rt], oldFreq + 1);
            }
            if(numPairs>=k)
                ans += n - rt;
            int oldFreq = freq.get(nums[lt]);
            freq.put(nums[lt], oldFreq - 1);
            numPairs -= oldFreq - 1;
        }
        return ans;
    }
}