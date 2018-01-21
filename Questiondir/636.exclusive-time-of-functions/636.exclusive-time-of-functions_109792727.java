public class Solution {
	private static class Element {
		public int id;
		public int timestamp;
		public Element(int id , int timestamp) {
			this.id = id;
			this.timestamp = timestamp;
		}
	}
	
    public int[] exclusiveTime(int n, List<String> logs) {
     
    	LinkedList<Element> stack = new LinkedList<>();
    	int i , m = logs.size();
    	int[] ans = new int[n];
    	int current = 0;
    	for (i = 0;i < m;i ++) {
    		String s = logs.get(i);
    		String[] strs = s.split(":");
    		int id = Integer.parseInt(strs[0]);
    		String type = strs[1];
    		int timestamp = Integer.parseInt(strs[2]);
    		if (type.equals("end")) {
    			timestamp ++;
    		}
    		if (stack.isEmpty()) {
    			stack.push(new Element(id , timestamp));
    		} else {
    			if (type.equals("start")) {
    				ans[stack.peek().id] += (timestamp - current);
    				stack.push(new Element(id , timestamp));
    			} else {
    				ans[stack.peek().id] += (timestamp - current);
    				stack.pop();
    			}
    		}
    		current = timestamp;
    	}
    	return ans;
    	
    }
}