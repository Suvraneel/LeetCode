
class Solution {
    private class TrieNode {
        int freq = 0;
        TrieNode[] children = new TrieNode[26];
    }
    private class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        public void insertWord(char[] word, int startIdx){
            TrieNode curr = root;
            for(int i=startIdx; i<word.length; i++){
                int c = word[i] - 'a';
                if(curr.children[c]==null)
                    curr.children[c] = new TrieNode();
                curr = curr.children[c];
                curr.freq += 1;
            }
        }

        public boolean countOccurances(String word){
            TrieNode curr = root;
            for(char x: word.toCharArray()){
                int c = x - 'a';
                if(curr.children[c]==null)
                    return false;
                curr = curr.children[c];
            }
            return curr.freq > 1;
        }

    }
    public List<String> stringMatching(String[] words) {
        Trie trie = new Trie();
        for(String w: words){
            char[] cs = w.toCharArray();
            for(int i=0; i<cs.length; i++)
                trie.insertWord(cs, i);
        }
        List<String> ans = new ArrayList<>();
        for(String w: words)
            if(trie.countOccurances(w))
                ans.add(w);
        return ans;
    }
}