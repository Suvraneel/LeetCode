/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    var sum=0;
    for(var i=0; i<k; i++)
        sum+=nums[i];
    var maxSum=sum;
    for(var i=0; i<nums.length-k; i++){
        sum+=nums[i+k]-nums[i];
        maxSum=Math.max(maxSum, sum);
    }
    return maxSum/k;
};