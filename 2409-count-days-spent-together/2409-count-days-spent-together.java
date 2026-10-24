class Solution {
    int[] MM_days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // prefix sum to get day number
        for (int i = 1; i <= 12; i++)
            MM_days[i] += MM_days[i - 1];
        int a1 = convert(arriveAlice), a2 = convert(leaveAlice), b1 = convert(arriveBob), b2 = convert(leaveBob);
        if (a2 < b1 || b2 < a1)
            return 0;
        return Math.min(a2, b2) - Math.max(a1, b1) + 1;
    }

    int convert(String mm_dd) {
        String[] mmdd = mm_dd.split("-");
        int mm = Integer.parseInt(mmdd[0]), dd = Integer.parseInt(mmdd[1]);
        return MM_days[mm - 1] + dd;
    }
}