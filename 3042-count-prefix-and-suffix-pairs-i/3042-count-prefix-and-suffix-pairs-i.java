class Solution {
    private class TrieNode {
        int freq = 0;
        List<String> wordWithPathAsPrefix = new ArrayList<>();
        TrieNode[] children = new TrieNode[26];
    } 
    private class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s){
            TrieNode curr =  root;
            for(char c: s.toCharArray()){
                int i = c - 'a';
                if(curr.children[i]==null)
                    curr.children[i] = new TrieNode();
                curr = curr.children[i];
                curr.wordWithPathAsPrefix.add(s);
            }
            curr.freq++;
        }
        List<String> isPrefixOf(String s){
            TrieNode curr = root;
            for(char c: s.toCharArray()){
                int i = c - 'a';
                if(curr.children[i]==null)
                    return new ArrayList<>();
                curr = curr.children[i];
            }
            return curr.wordWithPathAsPrefix;
        }
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        Trie trie = new Trie();
        for(int i = words.length - 1; i>=0; i--){
            String s = words[i];
            List<String> wordWithPathAsPrefix = trie.isPrefixOf(s);
            for(String w: wordWithPathAsPrefix){
                if(w.substring(w.length()-s.length()).equals(s))
                    count++;
            }
            trie.insert(s);
        }
        return count;
    }
}