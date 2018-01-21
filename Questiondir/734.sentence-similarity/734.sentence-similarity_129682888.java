class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
			return false;
		}
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p: pairs) {
        	if (!map.containsKey(p[0])) {
        		map.put(p[0], new HashSet<>());
        	}
        	map.get(p[0]).add(p[1]);
        	if (!map.containsKey(p[1])) {
        		map.put(p[1], new HashSet<>());
        	}
        	map.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < words1.length; i++) {
        	if (words1[i].equals(words2[i]) || (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]))) {
        		continue;
        	} else {
        		return false;
        	}
        }
        return true;
    }
}