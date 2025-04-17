class Solution {
    public int countPairs(int[] nums, int k) {
        List<Integer>[] seen = new List[101];
        int n = nums.length, count = 0;
        for(int i=0; i<101; i++)
            seen[i] = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j: seen[nums[i]])
                if((i*j)%k==0)
                    count++;
            seen[nums[i]].add(i);
        }
        return count;
    }
}