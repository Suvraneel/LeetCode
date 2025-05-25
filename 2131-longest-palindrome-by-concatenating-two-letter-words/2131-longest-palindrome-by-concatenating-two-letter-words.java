class Solution {
    public int longestPalindrome(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for (String w : words) {
            String rev = w.charAt(1) + "" + w.charAt(0);
            if (set.contains(rev)) {
                set.remove(rev);
                count += 2;
            } else
                set.add(w);
        }
        for (String w : set) {
            String rev = w.charAt(1) + "" + w.charAt(0);
            if (w.equals(rev)) {
                count++;
                break;
            }
        }
        return count * 2;
    }
}