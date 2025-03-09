class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, streak = 0, numGrps = 0, lt = 0, rt = 0, prev = -1;
        for (; rt < n + k - 1; rt++) {
            if (colors[rt % n] == prev) {
                streak = 1;
                lt = rt;
            } else {
                streak++;
                prev = colors[rt % n];
                if (streak == k) {
                    // System.out.println(lt + "\t" + rt);
                    numGrps++;
                    lt++;
                    streak--;
                }
            }
        }
        return numGrps;
    }
}