class Solution {
    private class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean isVisited = false;
    }

    private class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        boolean insert(String folder) {
            String[] path = folder.split("/");
            TrieNode curr = root;
            for (String dir : path) {
                curr.children.putIfAbsent(dir, new TrieNode());
                curr = curr.children.get(dir);
                if (curr.isVisited)
                    return false;
            }
            return curr.isVisited = true;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> prunedFolderList = new ArrayList<>();
        Trie trie = new Trie();
        for (String f : folder)
            if (trie.insert(f))
                prunedFolderList.add(f);
        return prunedFolderList;
    }
}