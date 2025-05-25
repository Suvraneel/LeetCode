class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String w : words) {
            String rev = w.charAt(1) + "" + w.charAt(0);
            if (map.containsKey(rev)) {
                map.put(rev, map.get(rev) - 1);
                if (map.get(rev) == 0)
                    map.remove(rev);
                count += 2;
            } else
                map.put(w, map.getOrDefault(w, 0) + 1);
        }
        // System.out.println(map);
        for (String w : map.keySet()) {
            String rev = w.charAt(1) + "" + w.charAt(0);
            if (w.equals(rev)) {
                count++;
                break;
            }
        }
        return count * 2;
    }
}