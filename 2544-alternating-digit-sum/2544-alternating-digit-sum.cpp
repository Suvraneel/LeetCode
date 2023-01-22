class Solution {
public:
    int alternateDigitSum(int n) {
        int ans = 0, sign = 1; 
        while (n) {
            sign *= -1; 
            ans += n % 10 * sign; 
            n /= 10; 
        }
        return ans * sign; 
    }
};