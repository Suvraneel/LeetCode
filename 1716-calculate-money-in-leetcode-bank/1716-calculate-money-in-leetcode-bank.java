class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7, days = n % 7;
        // ans = AP for complete weeks + AP for remaining days
        // ans = [7 * (4 + 5 + 6 + ...weeks)] + [(1+weeks) + (2+weeks) + ...days]
        // ans = 7 * Sum of AP, Sn = 7 * n/2 * 2a + (n-1) * d/
        return (int)((7 * (8 + (weeks - 1)) * (weeks / 2f)) + ((2 * (1 + weeks) + (days - 1)) * (days / 2f)));
    }
}