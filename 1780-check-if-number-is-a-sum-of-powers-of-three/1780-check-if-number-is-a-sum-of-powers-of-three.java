class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) // extract current LSB
                return false;
            n /= 3; // right shift ternary bit
        }
        return true;
    }
}