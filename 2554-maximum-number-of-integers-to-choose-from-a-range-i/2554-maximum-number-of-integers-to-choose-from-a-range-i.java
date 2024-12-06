class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>();
        for(int b: banned)
            ban.add(b);
        int sum = 0, ct = 0;
        for (int i = 1; i <= n && sum <= maxSum; i++) {
            if (ban.contains(i))
                continue;
            sum += i;
            ct++;
        }
        // System.out.println(sum);
        return sum > maxSum ? ct - 1 : ct;
    }
}