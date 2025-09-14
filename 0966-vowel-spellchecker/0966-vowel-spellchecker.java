class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> mapExact = new HashMap<>();
        Map<String, String> mapCapitalize = new HashMap<>();
        Map<String, String> mapError = new HashMap<>();
        int m = wordlist.length, n = queries.length;
        for (int i = m - 1; i >= 0; i--) {
            mapExact.put(wordlist[i], wordlist[i]);
            mapCapitalize.put(wordlist[i].toLowerCase(), wordlist[i]);
            mapError.put(wordlist[i].toLowerCase().replaceAll("[aeiou]", "*"), wordlist[i]);
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