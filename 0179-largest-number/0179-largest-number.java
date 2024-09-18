class Solution {
    public String largestNumber(int[] nums) {
        String[] s = Arrays.stream(nums).mapToObj(k -> String.valueOf((Integer) k)).toArray(String[]::new);
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        // System.out.println(Arrays.toString(s));
        if(s[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String w : s)
            sb.append(w);
        return sb.toString();
    }
}