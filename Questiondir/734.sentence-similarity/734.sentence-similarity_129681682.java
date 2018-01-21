class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        Map<String, Set<String>> dict = new HashMap<>();
        for(String[] pair: pairs){
            dict.putIfAbsent(pair[0], new HashSet<>());
            dict.get(pair[0]).add(pair[1]);
            dict.putIfAbsent(pair[1], new HashSet<>());
            dict.get(pair[1]).add(pair[0]);
        }
        for(int i = 0; i < words1.length; i++) {
            if(words1[i].equals(words2[i])) continue;
            if(!dict.containsKey(words1[i]) || !dict.get(words1[i]).contains(words2[i])) return false;
        }
        return true;
    }
}