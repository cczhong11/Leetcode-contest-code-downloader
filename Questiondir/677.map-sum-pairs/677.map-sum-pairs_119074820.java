 class MapSum {

		private static class TrieNode {
			public TrieNode[] nexts = new TrieNode[26];
			public int value = 0;
		}
		
		private TrieNode root = new TrieNode();
		
	    /** Initialize your data structure here. */
	    public MapSum() {
	    }
	    
	    public void insert(String key, int val) {
	        
	    	TrieNode node = root;
	    	int i , length = key.length();
	    	for (i = 0;i < length;i ++) {
	    		int index = key.charAt(i) - 'a';
	    		if (node.nexts[index] == null) {
	    			node.nexts[index] = new TrieNode();
	    		}
	    		node = node.nexts[index];
	    	}
	    	node.value = val;
	    	
	    }
	    
	    public int sum(String prefix) {
	        
	    	return dfs(root , prefix , 0);
	    	
	    }
	    
	    private int dfs(TrieNode node , String prefix , int current) {
	    	
	    	if (current >= prefix.length()) {
		    	int ans = 0;
	    		ans += node.value;
	    		for (int i = 0;i < 26;i ++) {
	    			if (node.nexts[i] != null) {
	    				ans += dfs(node.nexts[i] , prefix , current + 1);
	    			}
	    		}
	    		return ans;
	    	} else {
	    		int index = prefix.charAt(current) - 'a';
	    		if (node.nexts[index] != null) {
	    			return dfs(node.nexts[index] , prefix , current + 1);
	    		} else {
	    			return 0;
	    		}
	    	}
	    	
	    }
	    
	}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */