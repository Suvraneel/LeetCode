class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n: nums)
            freq.put(n, freq.getOrDefault(n, 0)+1);
        List<Pair<Integer, Integer>> rFreq = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: freq.entrySet())
            rFreq.add(new Pair<>(e.getValue(), e.getKey()));
        rFreq = rFreq.stream().sorted(Comparator.comparingInt(Pair<Integer, Integer>::getKey).thenComparing(Pair::getValue, Comparator.reverseOrder())).collect(Collectors.toList());
        // System.out.println(rFreq);
        int[] ans = new int[nums.length];
        int idx = 0;
        for(Pair<Integer, Integer> p: rFreq){
            int ct = p.getKey(), n = p.getValue();
            while(ct-->0)
                ans[idx++] = n; 
        }
        return ans;
    }
}