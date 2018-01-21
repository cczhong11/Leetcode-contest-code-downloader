class Solution {
	private static class Element {
		public String string;
		public int dist;
		public Element(String string , int dist) {
			this.string = string;
			this.dist = dist;
		}
	}
	
	private Set<String> vis = new HashSet<>();

	private char getPrev(char ch) {
		
		if (ch == '0') {
			return '9';
		} else {
			return (char) (ch - 1);
		}
		
	}
	
	private char getNext(char ch) {
		
		if (ch == '9') {
			return '0';
		} else {
			return (char) (ch + 1);
		}
		
	}
	
    public int openLock(String[] deadends, String target) {
        
    	for (String string : deadends) {
    		vis.add(string);
    		if ("0000".equals(string)) {
    			return - 1;
    		}
    	}
    	
    	Queue<Element> queue = new LinkedList<>();
    	queue.add(new Element("0000" , 0));
    	vis.add("0000");
    	while (!queue.isEmpty()) {
    		Element e = queue.poll();
    		char[] array = e.string.toCharArray();
    		for (int i = 0;i < array.length;i ++) {
    			char temp = array[i];
    			array[i] = getPrev(temp);
    			String next = new String(array);
    			if (next.equals(target)) {
    				return e.dist + 1;
    			} else {
    				if (!vis.contains(next)) {
    					vis.add(next);
    					queue.add(new Element(next , e.dist + 1));
    				}
    			}
    			array[i] = getNext(temp);
    			next = new String(array);
    			if (next.equals(target)) {
    				return e.dist + 1;
    			} else {
    				if (!vis.contains(next)) {
    					vis.add(next);
    					queue.add(new Element(next , e.dist + 1));
    				}
    			}
    			array[i] = temp;
    		}
    	}
    	return - 1;
    	
    }
}