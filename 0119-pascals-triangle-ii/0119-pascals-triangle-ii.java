class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0)
            return new ArrayList<>(List.of(1));
        List<Integer> prevRow = getRow(rowIndex-1);
        List<Integer> currRow = new ArrayList<>(List.of(1));
        for(int i=1; i<rowIndex; i++)
            currRow.add(prevRow.get(i-1)+prevRow.get(i));
        currRow.add(1);
        return currRow;
    }
}