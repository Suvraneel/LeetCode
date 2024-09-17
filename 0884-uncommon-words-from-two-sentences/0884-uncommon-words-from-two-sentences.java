class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Boolean> m = new HashMap<>();
        Arrays.stream(s1.split(" ")).forEach(w -> m.put(w, m.containsKey(w) ? false : true));
        Arrays.stream(s2.split(" ")).forEach(w -> m.put(w, m.containsKey(w) ? false : true));
        return m.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).toArray(String[]::new);
    }
}