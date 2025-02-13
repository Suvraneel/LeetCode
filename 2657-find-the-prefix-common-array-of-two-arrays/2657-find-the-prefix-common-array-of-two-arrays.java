class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, cumulative = 0;
        int[] visited = new int[n + 1], prefixCommon = new int[n];
        for (int i = 0; i < n; i++) {
            if (++visited[A[i]] == 2)
                cumulative++;
            if (++visited[B[i]] == 2)
                cumulative++;
            prefixCommon[i] = cumulative;
        }
        return prefixCommon;
    }
}