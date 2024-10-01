class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int i : arr)
            freq[((i % k) + k) % k]++;
        // System.out.println(Arrays.toString(freq));
        for (int i = 1; i < k; i++)
            if (freq[i] != freq[k - i])
                return false;
        return freq[0] % 2 == 0;
    }
}