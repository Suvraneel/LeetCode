class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==1)
            return new ArrayList<>(List.of(List.of(1)));
        List<List<Integer>> res = generate(numRows-1);
        List prevLine = res.get(numRows-2);
        List line = new ArrayList<>();
        line.add(1);
        for(int i=1; i<numRows-1; i++){
            line.add((int)prevLine.get(i-1)+(int)prevLine.get(i));
        }
        line.add(1);
        res.add(line);
        return res;
    }
}