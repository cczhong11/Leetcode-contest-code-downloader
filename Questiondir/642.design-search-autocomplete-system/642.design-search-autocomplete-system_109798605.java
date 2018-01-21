	public class AutocompleteSystem {
		
		private static class TrieNode {
			public TrieNode[] nexts = new TrieNode[27];
			public boolean flag = false;
			public int cnt = 0;
		}
		
		private StringBuilder input = new StringBuilder();
		private TrieNode root = new TrieNode();
		
	    public AutocompleteSystem(String[] sentences, int[] times) {
	       
	    	int i , n = sentences.length;
	    	for (i = 0;i < n;i ++) {
	    		String word = sentences[i];
	    		insert(root , word , times[i]);
	    	}
	    	
	    }
	    
	    public List<String> input(char c) {
	    	
	    	if (c == '#') {
	    		String word = input.toString();
	    		input.setLength(0);
	    		insert(root , word , 1);
	    		return Arrays.asList();
	    	} else {
	    		input.append(c);
	    		List<String> list = search(input.toString());
	    		return list;
	    	}
	        
	    }
	    
	    private Map<String , Integer> map = new HashMap<>();
	    
	    private static class Element implements Comparable<Element> {
	    	public String word;
	    	public int cnt;
	    	public Element(String word , int cnt) {
	    		this.word = word;
	    		this.cnt = cnt;
	    	}
	    	public int compareTo(Element e) {
	    		if (this.cnt > e.cnt) {
	    			return - 1;
	    		} else if (this.cnt < e.cnt) {
	    			return 1;
	    		} else {
	    			return this.word.compareTo(e.word);
	    		}
	    	}
	    }
	    
	    private List<String> search(String prefix) {
	    	
	    	List<Element> list = new ArrayList<>();
	    	map.clear();
	    	
	    	TrieNode node = root;
	    	for (int i = 0;i < prefix.length();i ++) {
	    		int index = prefix.charAt(i) == ' ' ? 26 : (prefix.charAt(i) - 'a');
	    		if (node.nexts[index] == null) {
	    			return Arrays.asList();
	    		} else {
	    			node = node.nexts[index];
	    		}
	    	}
	    	dfs(node , new StringBuilder() , prefix);
	    	for (Map.Entry<String , Integer> entry : map.entrySet()) {
	    		list.add(new Element(entry.getKey(), entry.getValue()));
	    	}
	    	
	    	Collections.sort(list);
	    	List<String> ans = new ArrayList<>();
	    	for (int i = 0;i < 3 && i < list.size();i ++) {
	    		ans.add(list.get(i).word);
	    	}
	    	
	    	return ans;
	    	
	    }
	    
	    private void dfs(TrieNode node , StringBuilder builder , String prefix) {
	    	
	    	if (node.flag) {
	    		String s = prefix + builder.toString();
	    		map.put(s , node.cnt);
	    	}
	    	
	    	for (int i = 0;i < 27;i ++) {
	    		if (node.nexts[i] != null) {
	    			char ch = (i == 26) ? ' ' : (char) (i + 'a');
	    			builder.append(ch);
	    			dfs(node.nexts[i] , builder , prefix);
	    			builder.deleteCharAt(builder.length() - 1);
	    		}
	    	}
	    	
	    }
	    
	    private void insert(TrieNode node , String word , int time) {
	    	
	    	int i , length = word.length();
	    	for (i = 0;i < length;i ++) {
	    		int index = 26;
	    		if (word.charAt(i) == ' ') {
	    			index = 26;
	    		} else {
	    			index = word.charAt(i) - 'a';
	    		}
	    		if (node.nexts[index] == null) {
	    			node.nexts[index] = new TrieNode();
	    		}
	    		node = node.nexts[index];
	    	}
	    	node.flag = true;
	    	node.cnt += time;
	    	
	    }
	    	
	}