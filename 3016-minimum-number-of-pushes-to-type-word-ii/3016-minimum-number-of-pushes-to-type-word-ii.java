class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        char[] S = word.toCharArray();
        int ans = 0, currAlloc = 1, allocLeft = 8;
        for(char c: S)
            count[c-'a']++;
        count = IntStream.of(count).boxed().sorted((a,b)->b-a).mapToInt(Integer::intValue).toArray();
        for(int i=0; i<26; i++)
            ans += count[i] * Math.floor(i/8 + 1);
        // System.out.println(Arrays.toString(count));
        return ans;
    }
}