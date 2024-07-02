class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersection = new ArrayList<>();
        for (int p1 = 0, p2 = 0; p1 < nums1.length && p2 < nums2.length;) {
            if (nums1[p1] == nums2[p2]) {
                intersection.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else
                p2++;
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}