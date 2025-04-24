class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++)
            set.put(nums[i], 1);
        int distinct = set.size();
        set.clear();
        for (int lt = 0, rt = 0; lt < n; lt++) {
            if (lt > 0) {
                int front = nums[lt - 1];
                set.put(front, set.get(front) - 1);
                if (set.get(front) == 0)
                    set.remove(front);
            }
            while (rt < n && set.size() < distinct){
                set.put(nums[rt], set.getOrDefault(nums[rt], 0) + 1);
                rt++;
            }
            // System.out.println(set);
            if (set.size() == distinct)
                count += n - (rt - 1);
        }
        return count;
    }
}