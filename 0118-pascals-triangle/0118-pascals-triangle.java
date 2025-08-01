class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prev = tri.get(tri.size() - 1);
            for (int j = 1; j < prev.size(); j++)
                row.add(prev.get(j - 1) + prev.get(j));
            row.add(1);
            tri.add(row);
        }
        return tri;
    }
}