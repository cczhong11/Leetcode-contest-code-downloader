public class Solution {
	private Map<Integer , TreeMap<Integer , Integer>> map = new HashMap<>();
	
    public boolean isPossible(int[] nums) {
        
    	for (int value : nums) {
    		if (!map.containsKey(value)) {
    			map.put(value , new TreeMap<>());
    		}
    		if (map.containsKey(value - 1)) {
    			TreeMap<Integer , Integer> tMap1 = map.get(value - 1);
    			if (!tMap1.isEmpty()) {
    				int cnt = tMap1.firstKey();
    				tMap1.put(cnt , tMap1.get(cnt) - 1);
    				if (tMap1.get(cnt) == 0) {
    					tMap1.remove(cnt);
    				}
    				cnt ++;
    				TreeMap<Integer , Integer> tMap2 = map.get(value);
        			if (!tMap2.containsKey(cnt)) {
        				tMap2.put(cnt , 1);
        			} else {
        				tMap2.put(cnt , tMap2.get(cnt) + 1);
        			}
    			} else {
    				TreeMap<Integer , Integer> tMap = map.get(value);
        			if (!tMap.containsKey(1)) {
        				tMap.put(1 , 1);
        			} else {
        				tMap.put(1 , tMap.get(1) + 1);
        			}
    			}
    		} else {
    			TreeMap<Integer , Integer> tMap = map.get(value);
    			if (!tMap.containsKey(1)) {
    				tMap.put(1 , 1);
    			} else {
    				tMap.put(1 , tMap.get(1) + 1);
    			}
    		}
    	}
    	for (Map.Entry<Integer , TreeMap<Integer , Integer>> entry : map.entrySet()) {
    		TreeMap<Integer , Integer> tMap = entry.getValue();
    		for (Map.Entry<Integer , Integer> e : tMap.entrySet()) {
    			if (e.getKey() < 3) {
    				return false;
    			}
    		}
    	}
    	return true;
    		
    }
}