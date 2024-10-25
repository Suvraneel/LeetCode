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

        void insert(String folder) {
            String[] path = folder.split("/");
            TrieNode curr = root;
            for (String dir : path) {
                curr.children.putIfAbsent(dir, new TrieNode());
                curr = curr.children.get(dir);
                if(curr.isVisited)  // skip traversing a nested path of already seen dir
                    return;
            }
            curr.children.clear();  // clear subfolders encountered previously
            curr.isVisited = true;
        }

        boolean contains(String folder) {
            String[] path = folder.split("/");
            TrieNode curr = root;
            for (String dir : path) {
                if(!curr.children.containsKey(dir))
                    return false;
                curr = curr.children.get(dir);
            }
            return curr.isVisited;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (String f : folder)
            trie.insert(f);
        List<String> prunedFolderList = new ArrayList<>();
        for(String f: folder)
            if(trie.contains(f))
                prunedFolderList.add(f);
        return prunedFolderList;
    }
}