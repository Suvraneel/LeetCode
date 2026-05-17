class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];
        List<int[]> ans = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[0] > prev[1]) {
                ans.add(prev);
                prev = i;
            } else
                prev[1] = Math.max(prev[1], i[1]);
        }
        ans.add(prev);
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < res.length; i++)
            res[i] = ans.get(i);
        return res;
    }
}