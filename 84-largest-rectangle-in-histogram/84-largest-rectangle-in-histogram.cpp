class Solution {
public:
 int largestRectangleArea(vector<int>& height) {
    if (height.empty() || height.size() == 0) {
        return 0;
    }
    int lessFromLeft[height.size()]; // idx of the first bar the left that is lower than current
    int lessFromRight[height.size()]; // idx of the first bar the right that is lower than current
    lessFromRight[height.size()-1] = height.size();
    lessFromLeft[0] = -1;

    for (int i = 1; i < height.size(); i++) {
        int p = i - 1;

        while (p >= 0 && height[p] >= height[i]) {
            p = lessFromLeft[p];
        }
        lessFromLeft[i] = p;
    }

    for (int i = height.size() - 2; i >= 0; i--) {
        int p = i + 1;

        while (p < height.size() && height[p] >= height[i]) {
            p = lessFromRight[p];
        }
        lessFromRight[i] = p;
    }

    int maxArea = 0;
    for (int i = 0; i < height.size(); i++) {
        maxArea = max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    }

    return maxArea;
    }
};