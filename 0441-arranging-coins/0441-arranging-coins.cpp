class Solution {
public:
    int arrangeCoins(int n) {
        return (int)(sqrt(1+(long)8*n)-1)/2;
    }
};