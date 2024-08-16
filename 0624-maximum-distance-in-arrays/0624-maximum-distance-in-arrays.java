class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> arr1 = arrays.get(0);
        int min = arr1.get(0), max = arr1.get(arr1.size()-1), maxDist = 0;
        arrays = arrays.subList(1, arrays.size());
        for (List<Integer> arr : arrays) {
            maxDist = Math.max(maxDist,
                    Math.max(max - arr.get(0), arr.get(arr.size() - 1) - min));
            min = Math.min(min, arr.get(0));
            max = Math.max(max, arr.get(arr.size() - 1));
        }
        return maxDist;
    }
}