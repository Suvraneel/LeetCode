class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }
        // System.out.println(freq);
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() != freq.get((k - e.getKey()) % k))
                return false;
        }
        return true;
    }
}