import java.util.StringTokenizer;

class TrieNode {
    TrieNode[] subs = new TrieNode[26];
    boolean accept = false;
    
    public void insert(String word, int idx) {
        if (idx == word.length()) {
            accept = true;
        } else {
            int j = word.charAt(idx)-'a';
            if (subs[j] == null) {
                subs[j] = new TrieNode();
            }
            subs[j].insert(word, idx+1);
        }
    }
    public String search(String word, int idx) {
        if (accept) {
            return word.substring(0, idx);
        } else if (idx == word.length()) {
            return word;
        } else {
            int j = word.charAt(idx)-'a';
            if (subs[j] == null) {
                return word;
            } else {
                return subs[j].search(word, idx+1);
            }
        }
    }
}

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            root.insert(word, 0);
        }
        StringTokenizer toks = new StringTokenizer(sentence);
        StringBuilder sb = new StringBuilder();
        while (toks.hasMoreTokens()) {
            String tok = toks.nextToken();
            sb.append(root.search(tok, 0)+" ");
        }
        return sb.toString().trim();
    }
}