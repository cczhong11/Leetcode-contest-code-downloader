class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= stack.pop();
            }
            else {
                int cur = 0;
                if (op.equals("D")) {
                    cur = stack.peek() * 2;
                }
                else if (op.equals("+")) {
                    int pre = stack.pop();
                    cur = pre + stack.peek();
                    stack.push(pre);
                }
                else {
                    cur = Integer.valueOf(op);
                }
                sum += cur;
                stack.push(cur);
            }
        }
        return sum;
    }
}