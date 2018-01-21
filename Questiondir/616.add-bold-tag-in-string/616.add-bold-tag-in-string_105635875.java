public class Solution {
    class TrieNode {
        boolean isLeaf;
        Map<Character, TrieNode> map;
        public TrieNode() {
            map = new HashMap<>();
        }
    }
    TrieNode build(String[] dict) {
        TrieNode root = new TrieNode();
        for(String s : dict) {
            TrieNode current = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!current.map.containsKey(c)) current.map.put(c, new TrieNode());
                current = current.map.get(c);
            }
            current.isLeaf = true;
        }
        return root;
    }
    
    public String addBoldTag(String s, String[] dict) {
        int[] count = new int[s.length() + 1];
        if(dict.length == 0) return s;
        TrieNode root = build(dict), current = root;
        for(int i = 0; i < s.length(); i++) {
            current = root;
            for(int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if(current.map.containsKey(c)) current = current.map.get(c);
                else break;
                if(current.isLeaf) {
                    count[i]++;
                    count[j+1]--;
                }
            }
        }
        int accu = 0;
        Set<Integer> good = new HashSet<>(), bad = new HashSet<>();
        for(int i = 0; i < count.length; i++) {
            int prev = accu;
            accu += count[i];
            if(prev == 0 && accu > 0) {
                good.add(i);
            }
            else if(prev > 0 && accu == 0) bad.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= s.length(); i++) {
            if(good.contains(i)) {
                sb.append("<b>");
            }
            else if(bad.contains(i)) sb.append("</b>");
            if(i < s.length()) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}