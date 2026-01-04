class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int i : nums)
            ans += validDivSum(i);
        return ans;
    }

    private int validDivSum(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        if (set.size() == 4) {
            int sum = 0;
            for (int i : set)
                sum += i;
            return sum;
        }
        return 0;
    }
}