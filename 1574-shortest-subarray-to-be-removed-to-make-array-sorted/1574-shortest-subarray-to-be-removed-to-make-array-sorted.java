class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, lt = 0, rt;
        for (rt = n - 1; rt > 0 && arr[rt - 1] <= arr[rt]; rt--)
            ;
        int minRmLen = rt;
        while (lt < rt && (lt == 0 || arr[lt - 1] <= arr[lt])) {
            while (rt < n && arr[lt] > arr[rt])
                rt++;
            minRmLen = Math.min(minRmLen, rt - lt - 1);
            lt++;
        }
        return minRmLen;
    }
}