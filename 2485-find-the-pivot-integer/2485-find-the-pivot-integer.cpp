class Solution {
public:
    int pivotInteger(int n) {
        float x = sqrt(n*(n+1)/2);
        return x==floor(x) ? x : -1;
    }
};