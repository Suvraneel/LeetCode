class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        if (m > asteroids[asteroids.length - 1])
            return true;
        for (int i : asteroids) {
            if (m < i)
                return false;
            m += i;
        }
        return true;
    }
}