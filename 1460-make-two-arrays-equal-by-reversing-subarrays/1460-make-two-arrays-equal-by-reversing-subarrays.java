class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] freq = new int[1001];
        for (int i = 0; i < target.length; i++) {
            freq[target[i]]++;
            freq[arr[i]]--;
        }
        for (int i = 0; i < target.length; i++)
            if (freq[target[i]] != 0 || freq[arr[i]] != 0)
                return false;
        return true;
    }
}