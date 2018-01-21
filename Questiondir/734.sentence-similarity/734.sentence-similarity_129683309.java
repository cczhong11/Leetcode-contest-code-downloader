class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null) {
            return false;
        }
        int n1 = words1.length;
        int n2 = words2.length;
        if (n1 != n2) {
            return false;
        }
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            String s1 = pair[0];
            String s2 = pair[1];
            if (!map.containsKey(s1)) {
                map.put(s1, new HashSet<>());
            }
            if (!map.containsKey(s2)) {
                map.put(s2, new HashSet<>());
            }
            HashSet<String> set1 = map.get(s1);
            HashSet<String> set2 = map.get(s2);
            set1.add(s1);
            set1.add(s2);
            set2.add(s1);
            set2.add(s2);
        }
        for (int i = 0; i < n1; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i]) || !map.get(words1[i]).contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
}