class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int i : nums)
            ans += validDivSum(i);
        return ans;
    }

    private int validDivSum(int n) {
        int sum = 0, count = 0, i = 1;
        for (; i * i < n; i++) {
            if (n % i != 0)
                continue;
            sum += i + n / i;
            count += 2;
        }
        if (i * i == n) {
            sum += i;
            count++;
        }
        return count == 4 ? sum : 0;
    }
}