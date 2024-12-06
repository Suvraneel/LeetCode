class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int b = 0, blen = banned.length, sum = 0, ct = 0;
        for (int i = 1; i <= n && sum <= maxSum; i++) {
            while (b < blen && banned[b] < i)
                b++;
            if (b < blen && banned[b] == i)
                continue;
            sum += i;
            ct++;
        }
        // System.out.println(sum);
        return sum > maxSum ? ct - 1 : ct;
    }
}