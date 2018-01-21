class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ret = new int[n];
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && temperatures[stk.peek()] < temperatures[i]) {
                ret[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        return ret;
    }
}