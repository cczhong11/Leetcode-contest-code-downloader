		class MagicDictionary {

		private Set<String> set = new HashSet<>();
		
	    /** Initialize your data structure here. */
	    public MagicDictionary() {
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        for (String word : dict) {
	        	char[] array = word.toCharArray();
	        	int i , length = word.length();
		    	for (i = 0;i < length;i ++) {
		    		char prev = array[i];
		    		for (char ch = 'a';ch <= 'z';ch ++) {
		    			if (ch != prev) {
		    				array[i] = ch;
		    				set.add(new String(array));
		    				array[i] = prev;
		    			}
		    		}
		    	}
	        }
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	    	
	    	return set.contains(word);
	        
	    }
	    
	}
	

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */