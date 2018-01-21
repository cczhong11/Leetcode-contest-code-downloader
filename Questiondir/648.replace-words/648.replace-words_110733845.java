public class Solution {
    class TrieNode{
        boolean isEnd;
        Map<Character, TrieNode> map = new HashMap<>();
    }
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        String words[] = sentence.split(" ");
        for(int i= 0;i< words.length;i++){
            String r = getWordRoot(root, words[i]);
            if(r!=null) words[i] = r;
        }
        return String.join(" ", words);
    }
    String getWordRoot(TrieNode root, String s){
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!cur.map.containsKey(c)) return null;
            sb.append(c);
            cur = cur.map.get(c);
            if(cur.isEnd) return sb.toString();
        }
        return null;
    }
    TrieNode buildTrie(List<String>list){
        TrieNode root = new TrieNode();
        for(String s: list){
            addToTrie(s, root);
        }
        return root;
    }
    void addToTrie(String s, TrieNode tn){
        TrieNode cur = tn;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!cur.map.containsKey(c)) cur.map.put(c, new TrieNode());
            cur = cur.map.get(c);
        }
        cur.isEnd = true;
    }
}