class Solution {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		
		int n = asteroids.length;
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				stack.push(asteroids[i]);

			} else {
				int value = asteroids[i];
				if (value > 0) {
					stack.push(value);
				} else {
					boolean insert = true;
					while (!stack.isEmpty() && stack.peek() > 0) {
						if (stack.peek() < -value) {
							stack.pop();
						} else if (stack.peek() == -value) {
							stack.pop();
							insert = false;
							break;
						} else {
							insert = false;
							break;
						}
					}
					if (insert) {
						stack.push(value);
					}
				}
			}
		}
		
		int[] res = new int[stack.size()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}
}