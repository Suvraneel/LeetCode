class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList(Arrays.asList(1)));
        for(int i=1; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = pascal.get(i-1);
            row.add(1);
            for(int j=1; j<prevRow.size(); j++)
                row.add(prevRow.get(j-1) + prevRow.get(j));
            row.add(1);
            pascal.add(row);
        }
        return pascal;
    }
}