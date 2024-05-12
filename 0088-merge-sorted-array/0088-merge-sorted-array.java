class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=0, p2=0, i=0;
        int[] ans = new int[m+n];
        while(p1<m && p2<n)
                ans[i++] = nums1[p1]<nums2[p2] ? nums1[p1++]:nums2[p2++];
        while(p1<m)
            ans[i++] = nums1[p1++];
        while(p2<n)
            ans[i++] = nums2[p2++];
        IntStream.range(0, m+n).forEach(x->nums1[x] = ans[x]);
    }
}