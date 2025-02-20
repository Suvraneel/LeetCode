class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Long> vis = new HashSet<>();
        for (String s : nums)
            vis.add(parseBinary(s));
        int n = nums.length;
        long lim = (long) Math.pow(2, n);
        for (long i = 0; i < lim; i++) {
            if (vis.contains(i))
                continue;
            String ans = Long.toBinaryString(i);
            while (ans.length() < n)
                ans = "0" + ans;
            return ans;
        }
        return "";
    }

    private long parseBinary(String s) {
        long x = 0;
        for (char c : s.toCharArray())
            x = (x << 1) + (c - '0');
        return x;
    }
}