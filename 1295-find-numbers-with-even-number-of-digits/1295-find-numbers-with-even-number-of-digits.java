class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        for (int i : nums)
            if ((int) Math.log10(i) % 2 == 1)
                even++;
        return even;
    }
}