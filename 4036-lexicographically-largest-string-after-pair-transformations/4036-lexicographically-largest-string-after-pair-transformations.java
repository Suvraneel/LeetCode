class Solution {
    public String[] largestString(int[] nums) {
        String[] ans = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            for (int i = 0; i < 25; i++) {
                if (n % 2 == 1)
                    sb.append((char) ('a' + i));
                n >>= 1;
            }
            while (n-- > 0)
                sb.append('z');
            ans[j] = sb.reverse().toString();
            sb.setLength(0);
        }
        return ans;
    }
}