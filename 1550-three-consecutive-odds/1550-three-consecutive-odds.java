class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int conseqOddCt = 0;
        for (int i : arr) {
            if (conseqOddCt == 3)
                return true;
            if ((i & 1) == 1)
                conseqOddCt++;
            else
                conseqOddCt = 0;
        }
        return false;
    }
}