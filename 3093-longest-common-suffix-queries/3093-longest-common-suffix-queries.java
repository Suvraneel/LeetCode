class Solution {
    private class TrieNode {
        TrieNode[] children;
        int startIdx = -1;
        int startLen = -1;

        TrieNode(int idx, int len) {
            this.children = new TrieNode[26];
            this.startIdx = idx;
            this.startLen = len;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("\n[");
            for (int i = 0; i < 26; i++)
                sb.append((char) ('a' + i)).append("=>").append(children[i]).append(",");
            sb.append("\tIdx" + startIdx + "\tLen" + startLen + "]\n");
            return sb.toString();
        }
    }

    private class Trie {
        TrieNode end = new TrieNode(-1, Integer.MAX_VALUE);

        int search(String word) {
            char[] cs = word.toCharArray();
            TrieNode curr = this.end;
            for (int i = cs.length - 1; i >= 0; i--) {
                TrieNode temp = curr.children[cs[i] - 'a'];
                if (temp == null)
                    return curr.startIdx;
                curr = temp;
            }
            return curr.startIdx;
        }

        void build(String word, int idx) {
            char[] cs = word.toCharArray();
            TrieNode curr = this.end;
            if (cs.length < curr.startLen) { // update no match ("")
                curr.startIdx = idx;
                curr.startLen = cs.length;
            }
            for (int i = cs.length - 1; i >= 0; i--) {
                TrieNode temp = curr.children[cs[i] - 'a'];
                if (temp == null)
                    temp = new TrieNode(idx, cs.length);
                else if (temp.startLen > cs.length) { // update to shortest string on path
                    temp.startIdx = idx;
                    temp.startLen = cs.length;
                }
                curr = curr.children[cs[i] - 'a'] = temp;
            }
        }
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie suffixTrie = new Trie();
        for (int i = 0; i < wordsContainer.length; i++)
            suffixTrie.build(wordsContainer[i], i);
        // System.out.println(suffixTrie.end);
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++)
            ans[i] = suffixTrie.search(wordsQuery[i]);
        return ans;
    }
}