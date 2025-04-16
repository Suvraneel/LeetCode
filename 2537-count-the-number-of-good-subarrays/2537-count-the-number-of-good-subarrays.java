class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length, lt = 0, rt = 0, oldFreq, newFreq;
        long numPairs = 0, ans = 0;
        Map<Integer, Integer> freq = new HashMap<>(); 
        for(;rt<n; rt++){
            // expand window
            oldFreq = freq.getOrDefault(nums[rt], 0);
            newFreq = oldFreq + 1;
            freq.put(nums[rt], newFreq);
            numPairs += getCombinationsCount(newFreq) - getCombinationsCount(oldFreq);
            if(numPairs>=k){
                while(numPairs>=k && lt<rt){
                    oldFreq = freq.getOrDefault(nums[lt], 0);
                    newFreq = oldFreq - 1;
                    if(newFreq==0)
                        freq.remove(nums[lt]);
                    else freq.put(nums[lt], newFreq);
                    numPairs += getCombinationsCount(newFreq) - getCombinationsCount(oldFreq);
                    lt++;
                }
                ans += lt;
                // System.out.println(lt + "\t" + rt + "\t" + ans);
            }
        }
        return ans;
    }
    private int getCombinationsCount(int n){    // nCr, where r = 2
        return n * (n-1) / 2;
    }
}