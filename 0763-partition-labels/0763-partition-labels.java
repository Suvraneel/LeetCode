class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOcc = new int[26];
        Arrays.fill(lastOcc, -1);
        int n = s.length(), prev = -1, window = -1, count = 0;
        for (int i = 0; i < n; i++)
            lastOcc[s.charAt(i) - 'a'] = i;
        // System.out.println(Arrays.toString(lastOcc));
        List<Integer> parts = new ArrayList<>();
        for (int i = 0; i < n; i++){
            window = Math.max(window, lastOcc[s.charAt(i) - 'a']);
            if (i == window) {
                parts.add(i - prev);
                prev = i;
            }
        }
        return parts;
    }
}