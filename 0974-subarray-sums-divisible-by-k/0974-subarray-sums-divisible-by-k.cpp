// TLE Solution: O(n^2) => using (prefixSum[j]-prefixSum[i])%k==0
// class Solution {
// public:
//     int subarraysDivByK(vector<int>& nums, int k) {
//         int sum = 0, res = 0;
//         for (int i=0; i<nums.size(); i++)
//             if(!((nums[i]=sum+=nums[i])%k))   ++res;
//         for(int i=0; i<nums.size()-1; i++)
//             for(int j=i+1; j<nums.size(); j++)
//                 if(!((nums[j]-nums[i])%k))   ++res;
//         return res;
//     }
// };

// Optimised Solution: O(n) => using prefixSum[j]%k==prefixSum[i]%k
class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int prefixMod = 0, res = 0;
        vector<int> prefixModGrps(k,0); // keep count of similar remainder causing subarrays
        prefixModGrps[0]=1; // take into account solo element subarrays that are itself divisible by k
        for (int i=0; i<nums.size(); i++){
            prefixMod=(prefixMod+nums[i]%k+k)%k;
            res+=prefixModGrps[prefixMod]++;    // can be used in combo with any other prefixSum that belongs to the same mod group
        }
        return res;
    }
};