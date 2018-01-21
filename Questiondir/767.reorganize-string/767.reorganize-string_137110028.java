class Solution {
	private static class Element implements Comparable<Element> {
		public char ch;
		public int cnt;
		public Element(char ch , int cnt) {
			this.ch = ch;
			this.cnt = cnt;
		}
		public int compareTo(Element e) {
			if (this.cnt > e.cnt) {
				return - 1;
			} else if (this.cnt < e.cnt) {
				return 1;
			} else {
				if (this.ch < e.ch) {
					return - 1;
				} else if (this.ch > e.ch) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
	
    public String reorganizeString(String S) {
        
    	Map<Character , Integer> map = new HashMap<>();
    	int i , length = S.length();
    	for (i = 0;i < length;i ++) {
    		char ch = S.charAt(i);
    		if (!map.containsKey(ch)) {
    			map.put(ch , 1);
    		} else {
    			map.put(ch , map.get(ch) + 1);
    		}
    	}
    	PriorityQueue<Element> queue = new PriorityQueue<>();
    	for (Map.Entry<Character , Integer> entry : map.entrySet()) {
    		queue.add(new Element(entry.getKey() , entry.getValue()));
    	}
    	StringBuilder builder = new StringBuilder();
    	while (!queue.isEmpty()) {
    		if (queue.size() >= 2) {
    			List<Element> list = new ArrayList<>();
    			for (i = 0;i < 2;i ++) {
    				Element e = queue.poll();
    				builder.append(e.ch);
    				e.cnt --;
    				if (e.cnt > 0) {
    					list.add(e);
    				}
    			}
    			for (Element e : list) {
    				queue.add(e);
    			}
    		} else {
    			Element e = queue.poll();
    			builder.append(e.ch);
    			e.cnt --;
    			if (e.cnt > 0) {
    				return "";
    			}
    		}
    	}
    	return builder.toString();
    	
    }
}