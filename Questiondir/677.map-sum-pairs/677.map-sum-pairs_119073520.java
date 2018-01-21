	class MapSum {

		Map<String, Integer> map;
		
	    /** Initialize your data structure here. */
	    public MapSum() {
	        map = new HashMap<>();
	    }
	    
	    public void insert(String key, int val) {
	        map.put(key, val);
	    }
	    
	    public int sum(String prefix) {
	    	int ret = 0;
	        for(String key : map.keySet()){
	        	if(key.startsWith(prefix)){
	        		ret += map.get(key);
	        	}
	        }
	        return ret;
	    }
	}	
