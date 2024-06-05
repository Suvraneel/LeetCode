class Solution {
    int[] commonAlpha = new int[26]; 
    private void isCommon(String s){
        char[] S = s.toCharArray();
        int[] freq = new int[26]; 
        for(char c: S)
            freq[c-'a']++;
        for(int i=0; i<26; i++)
            commonAlpha[i] = Math.min(commonAlpha[i], freq[i]);
    }
    public List<String> commonChars(String[] words) {
        for(int i=0; i<26; i++)
            commonAlpha[i] = Integer.MAX_VALUE;
        for(String s: words)
            isCommon(s);
        List<String> ans = new ArrayList<>(); 
        for(int i=0; i<26; i++)
            while(commonAlpha[i]-->0)
                ans.add(String.valueOf((char)(i+'a')));
        return ans;
    }
}