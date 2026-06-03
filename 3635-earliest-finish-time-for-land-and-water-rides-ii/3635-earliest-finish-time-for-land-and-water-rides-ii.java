class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int t1 = Integer.MAX_VALUE, t2 = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++)
            t1 = Math.min(t1, landStartTime[i] + landDuration[i]);
        for (int i = 0; i < waterStartTime.length; i++)
            t2 = Math.min(t2, waterStartTime[i] + waterDuration[i]);
        int T1 = Integer.MAX_VALUE, T2 = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++)
            T1 = Math.min(T1, Math.max(t1, waterStartTime[i]) + waterDuration[i]);
        for (int i = 0; i < landStartTime.length; i++)
            T2 = Math.min(T2, Math.max(t2, landStartTime[i]) + landDuration[i]);
        return Math.min(T1, T2);
    }
}