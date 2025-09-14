class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> mapExact = new HashMap<>();
        Map<String, String> mapCapitalize = new HashMap<>();
        Map<String, String> mapError = new HashMap<>();
        for (String w: wordlist) {
            mapExact.put(w, wordlist[i]);
            mapCapitalize.put(w.toLowerCase(), wordlist[i]);
            mapError.put(w.toLowerCase().replaceAll("[aeiou]", "*"), wordlist[i]);
        }
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String q = queries[i];
            ans[i] = mapExact.getOrDefault(q,
                    mapCapitalize.getOrDefault(q.toLowerCase(),
                            mapError.getOrDefault(q.toLowerCase().replaceAll("[aeiou]", "*"),
                                    "")));
        }
        return ans;
    }
}