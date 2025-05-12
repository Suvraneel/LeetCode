class Solution {
    public int[] findEvenNumbers(int[] digits) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0)
                continue;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < n; k++) {
                    if ((digits[k] & 1) == 1 || k == i || k == j)
                        continue;
                    set.add(100 * digits[i] + 10 * digits[j] + digits[k]);
                }
            }
        }
        int[] ans = new int[set.size()];
        int k = 0;
        for (int i : set)
            ans[k++] = i;
        return ans;
    }
}