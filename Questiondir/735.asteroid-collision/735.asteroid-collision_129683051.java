class Solution {
  public int[] asteroidCollision(int[] asteroids) {
     
    	List<Integer> ans = new ArrayList<>();
    	LinkedList<Integer> stack = new LinkedList<>();
    	int i , n = asteroids.length;
    	for (i = 0;i < n;i ++) {
    		if (asteroids[i] > 0) {
    			stack.push(asteroids[i]);
    		} else {
    			while (!stack.isEmpty() && stack.peek() < Math.abs(asteroids[i])) {
    				stack.pop();
    			}
    			if (stack.isEmpty()) {
    				ans.add(asteroids[i]);
    			} else if (stack.peek() == Math.abs(asteroids[i])) {
    				stack.pop();
    			}
    		}
    	}
    	LinkedList<Integer> temp = new LinkedList<>();
    	while (!stack.isEmpty()) {
    		temp.push(stack.pop());
    	}
    	while (!temp.isEmpty()) {
    		ans.add(temp.pop());
    	}
    	int[] array = new int[ans.size()];
    	for (i = 0;i < ans.size();i ++) {
    		array[i] = ans.get(i);
    	}
    	return array;
    	
    }
}