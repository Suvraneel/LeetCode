class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<String> exactMatch = new HashSet<>();
        Map<String, String> mapCapitalize = new HashMap<>();
        Map<String, String> mapError = new HashMap<>();
        for (String w : wordlist) {
            exactMatch.add(w);
            String wl = w.toLowerCase();
            mapCapitalize.putIfAbsent(wl, w);
            String we = wl.chars().mapToObj(c -> vowels.contains((char) c) ? "*" : String.valueOf((char) c))
                    .collect(Collectors.joining());
            mapError.putIfAbsent(we, w);
        }
        String[] ans = new String[queries.length];
        int j = 0;
        for (String q : queries) {
            if (exactMatch.contains(q)) {
                ans[j++] = q;
                continue;
            }
            String ql = q.toLowerCase();
            if (mapCapitalize.containsKey(ql)) {
                ans[j++] = mapCapitalize.get(ql);
                continue;
            }
            String qe = ql.chars().mapToObj(c -> vowels.contains((char) c) ? "*" : String.valueOf((char) c))
                    .collect(Collectors.joining());
            if (mapError.containsKey(qe)) {
                ans[j++] = mapError.get(qe);
                continue;
            }
            ans[j++] = "";
        }
        return ans;
    }
}
