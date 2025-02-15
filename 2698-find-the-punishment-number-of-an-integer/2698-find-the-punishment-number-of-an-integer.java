class Solution {
    public int punishmentNumber(int n) {
        int punishNum = 0;
        for (int i = 1; i <= n; i++)
            if (validTerm(i, i * i)) {
                // System.out.println(i+"✅");
                punishNum += i * i;
            }
        return punishNum;
    }

    private boolean validTerm(int match, int ltPart) {
        int rtPart = 0;
        // System.out.println(match + "===>");

        for (int d = 0; ltPart > 0; d++) {
            rtPart = (int) Math.pow(10, d) * (ltPart % 10) + rtPart;
            ltPart /= 10;
            // System.out.println(ltPart+"+"+rtPart);
            if (ltPart + rtPart == match || validTerm(match - rtPart, ltPart))
                return true;
        }
        return false;
    }
}