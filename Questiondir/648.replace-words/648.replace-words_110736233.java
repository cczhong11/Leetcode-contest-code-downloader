class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[128];
        isWord = false;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(p.children[c] == null) p.children[c] = new TrieNode();
            p = p.children[c];
        }
        p.isWord = true;
    }
    int find(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(p.children[c] == null) return -1;
            if(p.children[c].isWord) return i;
            p = p.children[c];
        }
        return -1;
    }
}

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder s = new StringBuilder();
        Trie t = new Trie();
        for(String tmp : dict) t.insert(tmp); 
        int n = sentence.length();
        for(int i = 0; i < n; i++) {
            while(i < n && sentence.charAt(i)==' ') {
                i++;
                s.append(" ");
            }
            if(i == n) break;
            int start = i;
            while(i < n && sentence.charAt(i) != ' ') i++;
            String cur = sentence.substring(start, i);
            int x = t.find(cur);
            if(x == -1) s.append(cur);
            else s.append(cur.substring(0, x+1));
            i--;
        }
        return s.toString();
    }
}