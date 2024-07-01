class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCt = 0;
        for (int i : arr) {
            if (i % 2 == 1)
                oddCt++;
            else
                oddCt = 0;
            if (oddCt == 3)
                return true;
        }
        return false;
    }
}