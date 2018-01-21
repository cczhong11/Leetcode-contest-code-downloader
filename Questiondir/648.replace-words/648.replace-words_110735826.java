public class Solution {
    //trie
    class TrieNode {
        
        private TrieNode[] children;
        public boolean isWord;
        public String wordd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for(String word: dict) {
            TrieNode cur = root;
            for(char ch: word.toCharArray()) {
                if(cur.children[ch - 'a'] == null)  cur.children[ch - 'a'] = new TrieNode();
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
            cur.wordd = word;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String word: sentence.trim().split(" ")) {
            sb.append(search(word, root));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    public String search(String item, TrieNode root) {
        TrieNode cur = root;
        for(char ch: item.toCharArray()) {
            if(cur.isWord == true)  return cur.wordd;
            if(cur.children[ch - 'a'] == null)  return item;
            else  cur = cur.children[ch - 'a'];
        }
        return item;
    }
}