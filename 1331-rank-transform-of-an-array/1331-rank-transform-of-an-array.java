class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return new int[0];
        int[] clone = arr.clone();
        Arrays.sort(clone);
        int idx = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(clone[0], ++idx);
        for (int i = 1; i < clone.length; i++)
            if (clone[i] != clone[i - 1])
                m.put(clone[i], ++idx);
            else
                m.put(clone[i], idx);
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            ans[i] = m.get(arr[i]);
        return ans;
    }
}