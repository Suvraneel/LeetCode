class Solution {
public:
    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int cy1 = max(ay1, by1), cx1 = max(ax1, bx1), cy2 = min(ay2, by2), cx2 = min(ax2, bx2);
        // cout << cx1 << cx2 << cy1 << cy2;
        int sumOfAreas = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
        if(bx1>=ax2 || by2<=ay1 || by1>=ay2 || bx2<=ax1)    // disjoint rects
            return sumOfAreas;
        int intersectionArea = (cy2-cy1)*(cx2-cx1);
        return sumOfAreas-intersectionArea;
    }
};