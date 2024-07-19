class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> s = new HashSet<>();
        List<Integer> lucky = new ArrayList<>();
        for(int[] r: matrix){
            int rowMin = Integer.MAX_VALUE;
            for(int c: r)
                rowMin = Math.min(c, rowMin);
            s.add(rowMin);
        }
        for(int j=0; j<matrix[0].length; j++){
            int colMax = Integer.MIN_VALUE;
            for(int i=0; i<matrix.length; i++)
                colMax = Math.max(matrix[i][j], colMax);
            if(s.contains(colMax))
                lucky.add(colMax);
        }
        return lucky;
    }
}