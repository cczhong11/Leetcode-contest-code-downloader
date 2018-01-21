class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
     
    	Map<String , Set<String>> map = new HashMap<>();
    	int i , n = pairs.length;
    	for (i = 0;i < n;i ++) {
    		String s1 = pairs[i][0] , s2 = pairs[i][1];
    		if (!map.containsKey(s1)) {
    			map.put(s1 , new HashSet<>());
    		}
    		map.get(s1).add(s2);
    		if (!map.containsKey(s2)) {
    			map.put(s2 , new HashSet<>());
    		}
    		map.get(s2).add(s1);
    	}
    	int n1 = words1.length , n2 = words2.length;
    	if (n1 == n2) {
    		for (i = 0;i < n1;i ++) {
    			if (words1[i].equals(words2[i])) {
    				continue;
    			} else {
    				if (map.containsKey(words1[i])) {
    					Set<String> set = map.get(words1[i]);
    					if (set.contains(words2[i])) {
    						continue;
    					} else {
    						return false;
    					}
    				} else {
    					return false;
    				}
    			}
    		}
    		return true;
    	} else {
    		return false;
    	}
    	
    }
}