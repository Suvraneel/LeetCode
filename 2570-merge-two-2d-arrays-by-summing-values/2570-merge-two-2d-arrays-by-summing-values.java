class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int ptr1 = 0, ptr2 = 0, n1 = nums1.length, n2 = nums2.length;
        List<int[]> list = new ArrayList<>();
        while (ptr1 < n1 && ptr2 < n2) {
            if (nums1[ptr1][0] == nums2[ptr2][0]) {
                list.add(new int[] { nums1[ptr1][0], nums1[ptr1][1] + nums2[ptr2][1] });
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1][0] < nums2[ptr2][0]) {
                list.add(nums1[ptr1]);
                ptr1++;
            } else {
                list.add(nums2[ptr2]);
                ptr2++;
            }
        }
        while (ptr1 < n1)
            list.add(nums1[ptr1++]);
        while (ptr2 < n2)
            list.add(nums2[ptr2++]);
        return list.toArray(new int[list.size()][]);
    }
}