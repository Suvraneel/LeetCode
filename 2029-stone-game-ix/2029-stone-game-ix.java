class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] bucket = new int[3];
        for (int i : stones)
            bucket[i % 3]++;
        if ((bucket[0] & 1) == 0)
            return bucket[1] >= 1 && bucket[2] >= 1;
        return Math.abs(bucket[1] - bucket[2]) > 2;
    }
}