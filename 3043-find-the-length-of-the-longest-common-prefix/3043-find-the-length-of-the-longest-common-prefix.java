class Solution {
    private int prefixLen = 0;
    private class TrieNode{
        TrieNode[] children;
        boolean isWord;

        TrieNode(){
            children = new TrieNode[10];
            isWord = true;
        }
    }

    private class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        void insert(int n){
            TrieNode curr = root;
            char[] cs = String.valueOf(n).toCharArray();
            for(char c: cs){
                int idx = c - '0';
                if(curr.children[idx]==null)
                    curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
            }
        }
        void longestPrefix(int n){
            int count = 0;
            TrieNode curr = root;
            char[] cs = String.valueOf(n).toCharArray();
            for(char c: cs){
                int idx = c - '0';
                if(curr.children[idx]==null)
                    break;
                count++;
                curr = curr.children[idx];
                if(curr.isWord)
                    prefixLen = Math.max(prefixLen, count);
            }
        }
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for(int i: arr1)
            trie.insert(i);
        for(int i: arr2)
            trie.longestPrefix(i);
        return prefixLen;
    }
}