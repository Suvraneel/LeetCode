class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int total = 0, ans = 0;
        TreeMap<Integer, Integer> prefixSum = new TreeMap<>();

        prefixSum.put(Integer.MIN_VALUE, 0);
        for (int[] f : fruits) {
            total += f[1];
            prefixSum.put(f[0], total);
        }
        prefixSum.put(Integer.MAX_VALUE, total);

        for (int i = 0; i <= k / 2 + 1; i++) {
            // Move right i, then left (k - 2*i)
            int right = prefixSum.get(prefixSum.floorKey(startPos + i));
            int leftLimit = (k < 2 * i) ? (startPos - 1) : (startPos - (k - 2 * i) - 1);
            int left = prefixSum.get(prefixSum.floorKey(leftLimit));
            ans = Math.max(ans, right - left);

            // Move left i, then right (k - 2*i)
            int left2 = prefixSum.get(prefixSum.floorKey(startPos - i - 1));
            int rightLimit = (k < 2 * i) ? startPos : (startPos + (k - 2 * i));
            int right2 = prefixSum.get(prefixSum.floorKey(rightLimit));
            ans = Math.max(ans, right2 - left2);

            System.out.println(i + "\t" + (right - left) + "\t" + (right2 - left2));
        }

        return ans;
    }
}
