class Solution {
    public long distributeCandies(int n, int limit) {
        return combination(n + 2, 2) - 3 * combination(n + 2 - (limit + 1), 2)
                + 3 * combination(n + 2 - 2 * (limit + 1), 2)
                - combination(n + 2 - 3 * (limit + 1), 2);
    }

    private long combination(int n, int r) { // nCr, where r=2 => nC2
        if (n < 2) // cant choose 2 items from a collection containing less that n objects
            return 0;
        return (long) n * (n - 1) / 2;
    }
}