class Solution {
    public int numberOfBeams(String[] bank) {
        int beams = 0, prev = 0;
        for (String r : bank) {
            int count = 0;
            for (char c : r.toCharArray())
                count += c - '0';
            if (count > 0) {
                beams += prev * count;
                prev = count;
            }
        }
        return beams;
    }
}