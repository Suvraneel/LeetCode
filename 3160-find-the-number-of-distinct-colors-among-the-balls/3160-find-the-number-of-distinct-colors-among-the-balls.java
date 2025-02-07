class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorFreqMap = new HashMap<>();
        HashMap<Integer, Integer> ballColorMap = new HashMap<>();
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int oldColor = ballColorMap.getOrDefault(x, 0);
            if (oldColor != 0) {
                colorFreqMap.put(oldColor, colorFreqMap.get(oldColor) - 1);
                if (colorFreqMap.get(oldColor) == 0)
                    colorFreqMap.remove(oldColor);
            }
            colorFreqMap.put(y, colorFreqMap.getOrDefault(y, 0) + 1);
            ballColorMap.put(x, y);
            result[i] = colorFreqMap.size();
        }
        return result;
    }
}