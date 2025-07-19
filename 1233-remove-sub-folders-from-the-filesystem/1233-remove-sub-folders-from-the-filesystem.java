class TrieNode {
    Map<String, TrieNode> dir = new HashMap<>();
    boolean vis = false;
    public String toString(){
        return dir.toString() + "\t" + vis;
    }
}
class Trie {
    public TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public String toString(){
        return root.toString();
    }
}
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for(String s: folder){
            String[] subdirs = s.split("/");
            TrieNode tn = trie.root;
            for(String d: subdirs){
                tn.dir.putIfAbsent(d, new TrieNode());
                tn = tn.dir.get(d);
            }
            tn.vis = true;
        }
        List<String> ans = new ArrayList<>();
        // System.out.println(trie);
        for(String s: folder){
            String[] subdirs = s.split("/");
            TrieNode tn = trie.root;
            boolean isSubFolder = false; 
            for(String d: subdirs){
                if(tn.vis){
                    isSubFolder = true;
                    break;
                }
                tn = tn.dir.get(d);
            }
            if(!isSubFolder)
                ans.add(s);
        }
        return ans;
    }
}