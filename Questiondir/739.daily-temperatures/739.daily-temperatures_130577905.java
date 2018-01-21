class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < res.length; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int pos = stack.pop();
				res[pos] = i - pos;
			}
			stack.push(i);
		}
		return res;
	}
}