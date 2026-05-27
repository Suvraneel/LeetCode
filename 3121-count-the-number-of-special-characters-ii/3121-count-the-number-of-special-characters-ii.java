class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Boolean> m = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                m.put(c, true);
            else {
                if (m.getOrDefault(Character.toUpperCase(c), false))
                    m.put(c, false);
                else
                    m.put(c, true);
            }
        }
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (m.getOrDefault((char) i, false) && m.getOrDefault(Character.toUpperCase((char) i), false))
                count++;
        }
        return count;
    }
}