	class MagicDictionary {
		
		String[] words;

	    /** Initialize your data structure here. */
	    public MagicDictionary() {
	        
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        words = dict;
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	    	for(String d : words){
	        	if(d.length() == word.length()){
	        		int dif = 0;
	        		for(int i = 0;i < d.length();i++){
	        			if(d.charAt(i) != word.charAt(i))dif++;
	        		}
	        		if(dif == 1)return true;
	        	}
	        }
	    	return false;
	    }
	}
	
	// 
