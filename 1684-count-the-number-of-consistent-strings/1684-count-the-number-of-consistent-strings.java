class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allow = allowed.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        int count = 0;
        for (String w : words) {
            boolean valid = true;
            for (char c : w.toCharArray())
                if (!allow.contains(c)) {
                    valid = false;
                    break;
                }
            if (valid)
                count++;
        }
        return count;
    }
}