class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> kv = new HashMap<>();
        for (List<String> l : knowledge)
            kv.put(l.get(0), l.get(1));
        StringBuilder sb = new StringBuilder(), ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ans.append(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                ans.append(kv.getOrDefault(sb.toString(), "?"));
                sb.setLength(0);
            } else
                sb.append(c);
        }
        ans.append(sb.toString());
        return ans.toString();
    }
}