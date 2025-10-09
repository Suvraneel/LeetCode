class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] wizFree = new long[n];
        for (int i = 0; i < m; i++) { // mana
            long curr = 0;
            for (int j = 0; j < n; j++) { // skill
                curr = Math.max(wizFree[j], curr) + mana[i] * skill[j]; // wizard's min time to end
            }
            wizFree[n - 1] = curr; // convoy effect for last wizard
            for (int j = n - 2; j >= 0; j--) // adjust all intermediate wizards to procrastinate until last wizard's req
                wizFree[j] = wizFree[j + 1] - mana[i] * skill[j + 1];
            // System.out.println(Arrays.toString(wizFree));
        }
        return wizFree[n - 1];
    }
}