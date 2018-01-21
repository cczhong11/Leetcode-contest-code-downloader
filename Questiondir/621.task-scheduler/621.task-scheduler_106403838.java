public class Solution {

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
				return 0;
			}
		}
	}
	
    public int leastInterval(char[] tasks, int n) {
        
    	n ++;
    	Map<Character , Integer> map = new HashMap<>();
    	for (char ch : tasks) {
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
    	int ans = 0;
    	while (!queue.isEmpty()) {
    		List<Element> nextList = new ArrayList<>();
    		if (queue.size() >= n) {
    			for (int i = 0;i < n;i ++) {
    				Element e = queue.poll();
    				e.cnt --;
    				if (e.cnt > 0) {
    					nextList.add(e);
    				}
    			}
    			ans += n;
    		} else {
    			int temp = queue.size();
    			while (!queue.isEmpty()) {
    				Element e = queue.poll();
    				e.cnt --;
    				if (e.cnt > 0) {
    					nextList.add(e);
    				}
    			}
    			if (nextList.isEmpty()) {
    				ans += temp;
    			} else {
    				ans += n;
    			}
    		}
    		for (Element e : nextList) {
    			queue.add(e);
    		}
    	}
    	return ans;
    	
    }

}