public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String word: dict) trie.insert(word);
        String[]  sent = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(String s : sent){
            res.append(trie.shortestPrefix(s)).append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}

class TrieNode {
    // Initialize your data structure here.
    TrieNode[] dic;
    boolean isleaf;
    public TrieNode() {
        dic=new TrieNode[26];
        isleaf=false;
    }
}

 class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode pointer=root;
        for(int i=0;i<word.length();i++){
            char ati=word.charAt(i);
            if(pointer.dic[ati-'a']!=null) pointer=pointer.dic[ati-'a'];
            else{
                pointer.dic[ati-'a']=new TrieNode();
                pointer=pointer.dic[ati-'a'];
            }
        }
        pointer.isleaf=true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public String shortestPrefix(String prefix) {
        TrieNode pointer=root;
        int i=0;
        while(i<prefix.length()){
            char ati=prefix.charAt(i++);
            if(pointer.dic[ati-'a']!=null){
                pointer=pointer.dic[ati-'a'];
                if(pointer.isleaf) return prefix.substring(0,i);
            }
            else return prefix;
        }
        return prefix;
    }
}