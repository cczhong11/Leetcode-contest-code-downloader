public class Solution {
    class MyTrieNode {
        String word;
        MyTrieNode[] children = new MyTrieNode[26];
    }

    private MyTrieNode buildTrie(List<String> words) {
        MyTrieNode root = new MyTrieNode();
        if(words == null || words.isEmpty()) return root;

        for(String w: words) {
            MyTrieNode node = root;
            for(char c: w.toCharArray()) {
                if(node.children[c-'a'] == null) {
                    node.children[c-'a'] = new MyTrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = w;
        }

        return root;
    }

    public String replaceWords(List<String> dict, String sentence) {
        if(sentence == null || sentence.isEmpty()) return sentence;
        String[] splits = sentence.split(" ");
        
        MyTrieNode trie = buildTrie(dict);
        for(int i=0; i<splits.length; i++) {
            String another = search(trie, splits[i]);
            if(another != null){
                splits[i] = another;
            }
        }
        
        return String.join(" ", splits);
    }
    
    private String search(MyTrieNode trie, String s) {
        for(char c: s.toCharArray()) {
            if(trie.children[c-'a'] == null) {
                return null;
            }
            trie = trie.children[c-'a'];
            if(trie.word != null) {
                return trie.word;
            }
        }
        
        return null;
    }
}