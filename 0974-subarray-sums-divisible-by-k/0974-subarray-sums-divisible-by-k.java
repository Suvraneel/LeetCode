class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0, res = 0;
        int[] modMap = new int[k];
        modMap[0] = 1;
        for(int n: nums){
            prefixSum = (prefixSum + n % k + k) % k; 
            res += modMap[prefixSum]++;
        }
        return res;
    }
}