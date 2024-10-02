class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> posn = new TreeMap<>();
        for(int i=0; i<n; i++){
            posn.putIfAbsent(arr[i], new ArrayList<>());
            List<Integer> sameRankIndexes = posn.get(arr[i]);
            sameRankIndexes.add(i);
            posn.put(arr[i], sameRankIndexes);
        }
        int[] ans = new int[n];
        int rank = 1;
        for(Map.Entry<Integer, List<Integer>> e: posn.entrySet()){
            List<Integer> sameRankIndexes = e.getValue();
            for(int i: sameRankIndexes)
                ans[i] = rank;
            rank++;
        }
        return ans;
    }
}