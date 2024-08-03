class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: target)
            freq.put(i, freq.getOrDefault(i, 0)+1);
        for(int i: arr)
            freq.put(i, freq.getOrDefault(i, 0)-1);
        for(Map.Entry<Integer, Integer> e: freq.entrySet())
            if(e.getValue()!=0)
                return false;
        return true;
    }
}