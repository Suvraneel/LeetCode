class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    return false;
                node = node.children[idx];
            }
            return node.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    return false;
                node = node.children[idx];
            }
            return true;
        }

        public String findRoot(String word) {
            TrieNode node = root;
            String root = "";
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    return null;
                root += c;
                node = node.children[idx];
                if (node.isEndOfWord)
                    return root;
            }
            return root;
        }

    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Trie dict = new Trie();
        for(String word: dictionary)
            dict.insert(word);
        for(int i=0; i<words.length; i++){
            String root = dict.findRoot(words[i]);
            if(root!=null)
                words[i] = root;
        }
        return String.join(" ", words);
    }
}