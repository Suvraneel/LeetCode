/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    var arr=[];
    for(var rt=0; rt<nums.length; rt++){
        if(arr[nums[rt]] && rt+1-arr[nums[rt]]<=k)
            return true;
        arr[nums[rt]]=rt+1;
    }
    return false;
};