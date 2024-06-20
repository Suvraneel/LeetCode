class Solution {
    int n;

    private boolean canPlace(int[] position, int gap, int m) {
        int prev = position[0], ct = 1;
        for (int i = 0; i < n && ct < m; i++) {
            if (position[i] - prev < gap)
                continue;
            ct++;
            prev = position[i];
        }
        return ct == m;
    }

    public int maxDistance(int[] position, int m) {
        n = position.length;
        Arrays.sort(position);
        int lt = 1, rt = position[n - 1], ans = 0;
        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if (canPlace(position, mid, m)) {
                ans = mid;
                lt = mid + 1;
            } else
                rt = mid - 1;
        }
        return ans;
    }
}