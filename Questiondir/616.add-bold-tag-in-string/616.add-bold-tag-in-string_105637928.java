public class Solution {
    private class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> nodes;
        
        TrieNode() {
            this.isWord = false;
            this.nodes = new HashMap<>();
        }
        
        public void insert(String word, int index) {
            if (index == word.length()) {
                this.isWord = true;
                return;
            }
            
            char curr = word.charAt(index);
            
            if (!this.nodes.containsKey(curr)) {
                this.nodes.put(curr, new TrieNode());
            }
            
            this.nodes.get(curr).insert(word, index + 1);
        }
        
        
        public int search(String source, int index) {
            int max = this.isWord ? index - 1 : - 1;
            if (index == source.length()) {
                return max;
            }
            
            char curr = source.charAt(index);
            
            if (!this.nodes.containsKey(curr)) {
                return max;
            }
            
            return Math.max(max, this.nodes.get(curr).search(source, index + 1));
        }
    }
    
    private String toString(boolean[] inside, String source) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < inside.length; i++) {
            if ((i == 0 || !inside[i - 1]) && inside[i]) {
                result.append("<b>");
            }
            result.append(source.charAt(i));
            if (inside[i] && (i == inside.length - 1 || !inside[i + 1])) {
                result.append("</b>");
            }
        }
        
        return result.toString();
    }
    
    public String addBoldTag(String s, String[] dict) {
        if (s == null || dict == null || dict.length == 0) {
            return s;
        } 
        
        TrieNode root = new TrieNode();
        for (String key : dict) {
            if (key == null || key.length() == 0) {
                continue;
            }
            root.insert(key, 0);
        }
        
        boolean[] inside = new boolean[s.length()];
        
        for (int i  = 0; i < s.length(); i++) {
            int end = root.search(s, i);
            for (int j = i; j <= end; j++) {
                inside[j] = true;
            }
        }
        
        //System.out.println(Arrays.toString(inside));
        return toString(inside, s);
        
    }
}