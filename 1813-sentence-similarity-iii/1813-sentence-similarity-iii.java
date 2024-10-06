class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence2.length() > sentence1.length()) {
            String temp = sentence2;
            sentence2 = sentence1;
            sentence1 = temp;
        }
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int n1 = words1.length, n2 = words2.length, lt = 0, rt = 0;
        if(n1==n2){
            for(int i=0; i<n1; i++)
                if(words1[i]!=words2[i])
                    return false;
            return true;
        }
        while (lt < n2 && words1[lt].equals(words2[lt]))
            lt++;
        while (rt < n2 && words1[n1 - 1 - rt].equals(words2[n2 - 1 - rt]))
            rt++;
        // System.out.println(lt + "\t" + rt + "\t" + n1 + "\t" + n2);
        if (lt + rt < n2)
            return false;
        return true;
    }
}