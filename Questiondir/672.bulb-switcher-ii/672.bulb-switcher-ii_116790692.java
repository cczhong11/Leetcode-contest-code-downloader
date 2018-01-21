class Solution {
	
	Map<String, List<String>> map = new HashMap<>();
	
    public int flipLights(int n, int m) {
    		Set<String> set = new HashSet<>();
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < n; i++) sb.append("1");
    		set.add(sb.toString());
    		while(m-- > 0) {
    			Set<String> newSet = new HashSet<>();
    			for(String bi: set) {
    				if(map.containsKey(bi)) {
    					newSet.addAll(map.get(bi));
    				} else {
    					List<String> candidates = new ArrayList<>();
    					
        				char[] ss = bi.toCharArray();
        				for(int i = 0; i < ss.length; i++) ss[i] = ss[i] == '0' ? '1' : '0'; 
        				candidates.add(new String(ss));
        				
        				ss = bi.toCharArray();
        				for(int i = 0; i < ss.length; i++) {
        					if(i % 2 == 0) continue;
        					ss[i] = ss[i] == '0' ? '1' : '0'; 
        				}
        				candidates.add(new String(ss));
        				
        				ss = bi.toCharArray();
        				for(int i = 0; i < ss.length; i++) {
        					if(i % 2 == 1) continue;
        					ss[i] = ss[i] == '0' ? '1' : '0'; 
        				} 
        				candidates.add(new String(ss));
        				
        				ss = bi.toCharArray();
        				for(int i = 0; i < ss.length; i++) {
        					if(i % 3 != 0) continue;
        					ss[i] = ss[i] == '0' ? '1' : '0'; 
        				}
        				candidates.add(new String(ss));
        				
    					newSet.addAll(candidates);
    					map.put(bi, candidates);
    				}
    			}
    			set = newSet;
    		}
    		return set.size();
    }
	
}