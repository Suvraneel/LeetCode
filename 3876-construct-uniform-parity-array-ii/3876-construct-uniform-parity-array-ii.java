class Solution {
    public boolean uniformArray(int[] nums1) {
        // Intuition: The minimum element in array must be odd,
        // that way it can reverse the parity of other even/odd elements
        // if its not odd, only viable condition is if entire array is even elems.
        int odd = 0, even = 0, min = Integer.MAX_VALUE;
        for (int i : nums1) {
            if ((i & 1) == 1)
                odd++;
            else
                even++;
            min = Math.min(min, i);
        }
        if ((min & 1) == 1)
            return true;
        else if (odd == 0)
            return true;
        return false;
    }
}