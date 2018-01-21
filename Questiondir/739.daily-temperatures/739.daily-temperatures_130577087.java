class Solution {
private static class Element {
		public int index;
		public int value;
		public Element(int value , int index) {
			this.index = index;
			this.value = value;
		}
	}

    public int[] dailyTemperatures(int[] temperatures) {
        
    	LinkedList<Element> stack = new LinkedList<>();
    	int i , j , n = temperatures.length;
    	int[] ans = new int[n];
    	for (i = 0;i < n;i ++) {
    		if (stack.isEmpty()) {
    			stack.push(new Element(temperatures[i] , i));
    		} else {
    			while (!stack.isEmpty() && stack.peek().value < temperatures[i]) {
    				ans[stack.peek().index] = i - stack.peek().index;
    				stack.pop();
    			}
    			stack.push(new Element(temperatures[i] , i));
    		}
    	}
    	return ans;
    	
    }
}