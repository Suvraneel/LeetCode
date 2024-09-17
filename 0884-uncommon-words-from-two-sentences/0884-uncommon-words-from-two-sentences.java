class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Boolean> m = new HashMap<>();
        String[] words = s1.split(" ");
        for (String w : words)
            m.put(w, m.containsKey(w) ? false : true);
        words = s2.split(" ");
        for (String w : words)
            m.put(w, m.containsKey(w) ? false : true);
        return m.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).toArray(String[]::new);
    }
}