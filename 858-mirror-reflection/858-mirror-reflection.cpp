class Solution {
public:
    int mirrorReflection(int p, int q) {
        int LCM = lcm(p, q);
        // => Satisfying Glass Box Corner at Point(LCM/p, LCM/q) => // ie, on top-rt corner of that box
        int isXMirrored = (LCM/q-1)%2, isYMirrored = (LCM/p-1)%2;   // (no. of boxes on each axis) %2
        return isXMirrored?2:isYMirrored?0:1;
    }
};