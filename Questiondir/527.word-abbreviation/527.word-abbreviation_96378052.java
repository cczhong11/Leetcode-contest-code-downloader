public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String s : dict) {
            if(s.length() > 3) {
                String r = s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
                map.putIfAbsent(r, new HashSet<String>());
                map.get(r).add(s);
            }
        }
        Map<String, String> myMap = new HashMap<>();
        for(String s : map.keySet()) {
            if(map.get(s).size() > 1) {
                build(map.get(s), myMap);
            }
        }
        List<String> result = new ArrayList<>();
        for(String s : dict) {
            if(s.length() < 4) result.add(s);
            else if(!myMap.containsKey(s)) result.add(s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1));
            else result.add(myMap.get(s));
        }
        return result;
    }
    class TrieNode{
        int count;
        Map<Character, TrieNode> map;
        String s;
        public TrieNode(){
            count = 0;
            map = new HashMap<>();
            s = "";
        }
    }
    void build(Set<String> set, Map<String, String> map) {
        TrieNode root = new TrieNode(), temp = root;
        for(String s : set) {
            temp = root;
            for(int j = 1; j < s.length() - 2; j++) {
                char c = s.charAt(j);
                temp.map.putIfAbsent(c, new TrieNode());
                temp = temp.map.get(c);
                temp.count++;
            }
        }
        for(String s : set) {
            temp = root;
            for(int j = 1; j < s.length() - 2; j++) {
                char c = s.charAt(j);
                temp = temp.map.get(c);
                if(temp.count == 1) {
                    if(s.length() - 2 - j > 1) map.put(s, s.substring(0, j + 1) + (s.length() - 2 - j) + s.charAt(s.length() - 1));
                    else map.put(s, s);
                    break;
                }
            }
            if(!map.containsKey(s)) map.put(s, s);
        }
    }
}