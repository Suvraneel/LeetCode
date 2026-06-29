class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] > 1)
            arr[0] = 1;
        int prev = 1, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] - prev > 1)
                arr[i] = prev + 1;
            prev = arr[i];
        }
        return arr[n - 1];
    }
}