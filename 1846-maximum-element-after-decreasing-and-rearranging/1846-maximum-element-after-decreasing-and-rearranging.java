class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int prev = 1, n = arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] - prev >= 1)
                ++prev;
        return prev;
    }
}