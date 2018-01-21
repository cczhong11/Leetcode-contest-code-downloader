public class Solution {
	private static class TrieNode {
		public TrieNode[] nexts = new TrieNode[26];
		public boolean flag = false;
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
	
    public String replaceWords(List<String> dict, String sentence) {
     
    	TrieNode root = new TrieNode();
    	for (String word : dict) {
    		insert(root , word);
    	}
    	
    	int i , length = sentence.length();
    	StringBuilder builder = new StringBuilder();
    	for (i = 0;i < length;i ++) {
    		if (sentence.charAt(i) != ' ') {
    			boolean find = false;
    			StringBuilder sb = new StringBuilder();
    			TrieNode node = root;
    			int temp = i;
    			while (i < length && sentence.charAt(i) != ' ') {
    				int index = sentence.charAt(i) - 'a';
    				if (node.nexts[index] != null) {
    					node = node.nexts[index];
    					sb.append(sentence.charAt(i));
    					// find
    					if (node.flag) {
    						find = true;
    						break;
    					}
    					i ++;
    				} else {    				
    					break;
    				}
    			}
    			if (find) {
    				builder.append(sb.toString());
    				while (i < length && sentence.charAt(i) != ' ') {
    					i ++;
    				}
    				i --;
    			} else {
    				i = temp;
    				while (i < length && sentence.charAt(i) != ' ') {
    					builder.append(sentence.charAt(i));
    					i ++;
    				}
    				i --;
    			}
    		} else {
    			builder.append(sentence.charAt(i));
    		}
    	}
    	return builder.toString();
    	
    }
}