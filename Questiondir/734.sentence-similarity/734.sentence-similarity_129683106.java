class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            
            if (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) {
                continue;
            }
            if (map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
}