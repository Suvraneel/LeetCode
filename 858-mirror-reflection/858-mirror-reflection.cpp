class Solution {
public:
    int mirrorReflection(int p, int q) {
        int LCM = lcm(p, q);
        // => Satisfying Glass Box Corner at Point(LCM/p, LCM/q) => // ie, on top-rt corner of that box
        int mirroredXcount = LCM/q-1, mirroredYcount = LCM/p-1;
        bool isXMirrored = mirroredXcount%2, isYMirrored = mirroredYcount%2;
        return isXMirrored?2:isYMirrored?0:1;
    }
};