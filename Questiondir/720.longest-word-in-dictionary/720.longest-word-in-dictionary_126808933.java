class Solution {
	private static class TrieNode {
		public TrieNode[] nexts = new TrieNode[26];
		public boolean flag = false;
	}
	
    public String longestWord(String[] words) {
     
    	TrieNode root = new TrieNode();
    	for (String word : words) {
    		insert(root , word);
    	}
    	String ans = null;
    	for (String word : words) {
    		if (check(word , root)) {
    			if (ans == null) {
    				ans = word;
    			} else {
    				if (word.length() > ans.length()) {
    					ans = word;
    				} else if (word.length() == ans.length()) {
    					if (word.compareTo(ans) < 0) {
    						ans = word;
    					}
    				}
    			}
    		}	
    	}
    	if (ans == null) {
    		ans = "";
    	}
    	return ans;
    	
    }
    
    private boolean check(String word , TrieNode root) {
    	
    	int i , length = word.length();
    	for (i = 0;i < length;i ++) {
    		int index = word.charAt(i) - 'a';
    		if (root.nexts[index] == null) {
    			return false;
    		}
    		root = root.nexts[index];
    		if (!root.flag) {
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    private void insert(TrieNode root , String word) {
    	
    	int i , length = word.length();
    	for (i = 0;i < length;i ++) {
    		int index = word.charAt(i) - 'a';
    		if (root.nexts[index] == null) {
    			root.nexts[index] = new TrieNode();
    		}
    		root = root.nexts[index];
    	}
    	root.flag = true;
    	
    }
}