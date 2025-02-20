class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> vis = new HashSet<>();
        for (String s : nums)
            vis.add(parseBinary(s));
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (vis.contains(i))
                continue;
            String ans = Integer.toBinaryString(i);
            while (ans.length() < n)
                ans = "0" + ans;
            return ans;
        }
        return "";
    }

    private int parseBinary(String s) {
        int x = 0;
        for (char c : s.toCharArray())
            x = (x << 1) + (c - '0');
        return x;
    }
}