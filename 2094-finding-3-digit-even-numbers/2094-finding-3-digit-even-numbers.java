class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int count[] = new int[10];
        List<Integer> ans = new ArrayList<>();
        for (int d : digits)
            count[d]++;

        for (int i = 1; i < 10; i++) {
            if (count[i] == 0)
                continue;
            --count[i];
            for (int j = 0; j < 10; j++) {
                if (count[j] == 0)
                    continue;
                --count[j];
                for (int k = 0; k < 10; k += 2) {
                    if (count[k] == 0)
                        continue;
                    int num = i * 100 + j * 10 + k;
                    ans.add(num);
                }
                ++count[j];
            }
            ++count[i];
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}