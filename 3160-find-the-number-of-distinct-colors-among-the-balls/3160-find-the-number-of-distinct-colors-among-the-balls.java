class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorsFreqMap = new HashMap<>();
        HashMap<Integer, Integer> ballsColorMap = new HashMap<>();
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (ballsColorMap.containsKey(x)) {
                int oldColor = ballsColorMap.get(x);
                colorsFreqMap.put(oldColor, colorsFreqMap.get(oldColor) - 1);
                if (colorsFreqMap.get(oldColor) == 0)
                    colorsFreqMap.remove(oldColor);
            }
            colorsFreqMap.put(y, colorsFreqMap.getOrDefault(y, 0) + 1);
            ballsColorMap.put(x, y);
            result[i] = colorsFreqMap.size();
        }
        return result;
    }
}