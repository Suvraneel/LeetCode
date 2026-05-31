class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass, last = asteroids[asteroids.length - 1];
        for (int i : asteroids) {
            if (m < i)
                return false;
            if (m >= last)
                return true;
            m += i;
        }
        return true;
    }
}