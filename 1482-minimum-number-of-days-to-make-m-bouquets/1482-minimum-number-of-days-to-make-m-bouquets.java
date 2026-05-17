class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int lt = Integer.MAX_VALUE, rt = 0, ans = -1;
        for (int b : bloomDay) {
            lt = Math.min(lt, b);
            rt = Math.max(rt, b);
        }
        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if (solve(bloomDay, mid, m, k)) {
                ans = mid;
                rt = mid - 1;
            } else
                lt = mid + 1;
        }
        return ans;
    }

    private boolean solve(int[] bloomDay, int d, int m, int k) {
        int streak = 0, bouq = 0;
        for (int i : bloomDay) {
            if (i <= d) {
                if (++streak == k) {
                    streak = 0;
                    if (++bouq == m)
                        return true;
                }
            } else
                streak = 0;
        }
        return false;
    }
}