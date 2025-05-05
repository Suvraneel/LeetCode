class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, major1 = Integer.MIN_VALUE, major2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            if (count2 == 0 && i != major1) { // moore voting but ignore major1 (since both candidate shouldnt be same)
                major2 = i;
                count2 = 1;
            } else if (count1 == 0 && i != major2) {
                major1 = i;
                count1 = 1;
            } else if (i == major1)
                count1++;
            else if (i == major2)
                count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums)
            if (i == major1)
                count1++;
            else if (i == major2)
                count2++;
        if (count1 > n / 3)
            ans.add(major1);
        if (count2 > n / 3)
            ans.add(major2);
        return ans;
    }
}