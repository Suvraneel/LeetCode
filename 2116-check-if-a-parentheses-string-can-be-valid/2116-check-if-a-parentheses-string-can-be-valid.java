class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length(), openCt = 0, liquidCt = 0;
        if (n % 2 == 1)
            return false;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0')
                liquidCt++;
            else if (s.charAt(i) == '(')
                openCt++;
            else {
                if (openCt > 0)
                    openCt--;
                else if (liquidCt > 0)
                    liquidCt--;
                else
                    return false;
            }
        }
        // Do the same but in reverse (to check validity of open parentheses)
        openCt = 0;
        liquidCt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0')
                liquidCt++;
            else if (s.charAt(i) == ')')
                openCt++;
            else {
                if (openCt > 0)
                    openCt--;
                else if (liquidCt > 0)
                    liquidCt--;
                else
                    return false;
            }
        }
        // System.out.println(openCt + "\t" + liquidCt);
        return true;
    }
}