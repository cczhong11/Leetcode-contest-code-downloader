class Solution {
	private Map<String , Set<Character>> map = new HashMap<>();
	private Map<String , Boolean> dp = new HashMap<>();
	
    public boolean pyramidTransition(String bottom, List<String> allowed) {
     
    	map.clear();
    	dp.clear();
    	for (String s : allowed) {
    		String string = s.charAt(0) + "" + s.charAt(1);
    		char ch = s.charAt(2);
    		if (!map.containsKey(string)) {
    			map.put(string , new HashSet<>());
    		}
    		map.get(string).add(ch);
    	}
    	return dfs(bottom);
    	
    }
    
    private boolean dfs(String string) {
    	
    	if (string.length() == 1) {
    		return true;
    	} else {
    		if (dp.containsKey(string)) {
    			return dp.get(string);
    		}
    		
    		boolean result = false;
    		List<String> list = new ArrayList<>();
    		StringBuilder builder = new StringBuilder();
    		getStrings(string , 1 , builder , list);
    		
    		for (String s : list) {
    			if (dfs(s)) {
    				result = true;
    				break;
    			}
    		}
    		
    		if (result) {
    			dp.put(string , true);
    		} else {
    			dp.put(string , false);
    		}
    		
    		return result;
    	}

    }
    
    private void getStrings(String string , int current , StringBuilder builder , List<String> list) {
    	
    	if (current == string.length()) {
    		list.add(builder.toString());
    	} else {
    		String temp = string.substring(current - 1 , current + 1);
    		if (map.containsKey(temp)) {
    			for (char ch : map.get(temp)) {
    				builder.append(ch);
    				getStrings(string , current + 1 , builder , list);
    				builder.deleteCharAt(builder.length() - 1);
    			}
    		}
    	}
    	
    }
}