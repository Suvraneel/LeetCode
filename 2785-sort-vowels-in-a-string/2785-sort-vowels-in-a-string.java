class Solution {
    public String sortVowels(String s) {
        char[] cs = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Character> l = new ArrayList<>();
        for (char c : cs)
            if (vowels.contains(c))
                l.add(c);
        Collections.sort(l);
        StringBuilder sb = new StringBuilder();
        int vi = 0;
        for (char c : cs)
            sb.append(vowels.contains(c) ? l.get(vi++) : c);
        return sb.toString();
    }
}