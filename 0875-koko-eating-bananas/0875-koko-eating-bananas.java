class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lt = 1, rt = 1;
        for (int p : piles)
            rt = Math.max(rt, p);
        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if (eat(piles, mid, h))
                rt = mid;
            else
                lt = mid + 1;
        }
        return rt;
    }

    private boolean eat(int[] piles, int k, int h) {
        for (int p : piles) {
            h -= (int) Math.ceil((double) p / k);
            if (h < 0)
                return false;
        }
        return true;
    }
}