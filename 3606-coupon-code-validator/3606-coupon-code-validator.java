class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<String> ans = new ArrayList<>();
        Queue<String[]> pq = new PriorityQueue<>((a, b) -> a[1].equals(b[1])
                ? a[0].compareTo(b[0])
                : a[1].compareTo(b[1]));
        Set<String> bizLines = new HashSet<>();
        bizLines.addAll(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));
        for (int i = 0; i < n; i++) {
            if (isValid(code[i], businessLine[i], isActive[i], bizLines))
                pq.offer(new String[] { code[i], businessLine[i] });
        }
        while (!pq.isEmpty())
            ans.add(pq.poll()[0]);
        return ans;
    }

    private boolean isValid(String code, String bizLine, boolean isActive, Set<String> bizLines) {
        if (!isActive)
            return false;
        if (!bizLines.contains(bizLine))
            return false;
        if (code.length() == 0)
            return false;
        code = code.toLowerCase();
        for (char c : code.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '_')
                continue;
            return false;
        }
        return true;
    }
}