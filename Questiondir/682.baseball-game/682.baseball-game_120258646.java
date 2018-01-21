class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(String o : ops) {
            int cur;
            if(o.equals("C")) {
                cur = -stack.pop();
            } else if(o.equals("D")) {
                cur = stack.peek() * 2;
                stack.push(cur);
            } else if(o.equals("+")) {
                int x = stack.pop();
                cur = stack.peek() + x;
                stack.push(x);
                stack.push(cur);
            } else {
                cur = Integer.valueOf(o);
                stack.push(cur);
            }
            sum += cur;
        }
        return sum;
    }
}