class MagicDictionary {

	Set<String> set = new HashSet<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String w : dict) set.add(w);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
    	StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
        	char old = sb.charAt(i);
        	for (char nch = 'a'; nch <= 'z'; nch++) if (nch != old) {
        		sb.setCharAt(i, nch);
        		if (set.contains(sb.toString())) return true;
        	}
        	sb.setCharAt(i, old);
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */