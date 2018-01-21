public class Solution {
    private class TrieNode{
        String word;
        TrieNode[] nexts = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    void add(String word){
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.nexts[c - 'a'] == null) cur.nexts[c - 'a'] = new TrieNode();
            cur = cur.nexts[c - 'a'];
        }
        cur.word = word;
    }

    String findPrefix(String word){
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.nexts[c - 'a'] == null) return null;
            cur = cur.nexts[c - 'a'];
            if(cur.word != null) return cur.word;
        }
        return null;
    }
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder ret = new StringBuilder();
        for(String word : dict) add(word);
        String[] words = sentence.split(" ");
        for(String word : words){


            if(ret.length() != 0) ret.append(' ');
            String prefix = findPrefix(word);
            if(prefix != null) ret.append(prefix);
            else ret.append(word);
        }
        return ret.toString();
    }
}