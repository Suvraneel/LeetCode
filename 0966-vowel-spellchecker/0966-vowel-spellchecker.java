class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch = new HashSet<>();
        Map<String, String> mapCapitalize = new HashMap<>();
        Map<String, String> mapError = new HashMap<>();
        int m = wordlist.length, n = queries.length, j = 0;
        for (int i = m - 1; i >= 0; i--) {
            exactMatch.add(wordlist[i]);
            mapCapitalize.put(wordlist[i].toLowerCase(), wordlist[i]);
            mapError.put(wordlist[i].toLowerCase().replaceAll("[aeiou]", "*"), wordlist[i]);
        }
        String[] ans = new String[n];
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
            String qe = q.toLowerCase().replaceAll("[aeiou]", "*");
            if (mapError.containsKey(qe)) {
                ans[j++] = mapError.get(qe);
                continue;
            } else
                ans[j++] = "";
        }
        return ans;
    }
}