class Solution {
    private class TrieNode {
        TrieNode[] children;
        int prefixCt;

        TrieNode() {
            children = new TrieNode[26];
            prefixCt = 0;
        }
    }

    private class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String s) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
                curr.prefixCt++;
                // System.out.print(c+"/"+curr.prefixCt+", ");
            }
            // System.out.println();
        }

        int calcPrefixScore(String s) {
            TrieNode curr = root;
            int prefixScore = 0;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                curr = curr.children[idx];
                prefixScore += curr.prefixCt;
                // System.out.print(curr.prefixCt+", ");
            }
            // System.out.println("="+prefixScore);
            return prefixScore;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String s : words)
            trie.insert(s);
        int n = words.length;
        int[] prefixScores = new int[n];
        for (int i = 0; i < n; i++)
            prefixScores[i] = trie.calcPrefixScore(words[i]);
        return prefixScores;
    }
}