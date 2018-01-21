class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int total = 0;
        for (String op : ops) {
            if (op.equals("C")) {
                total -= stack.pop();
            } else if (op.equals("D")) {
                int num = stack.peek() * 2;
                total += num;
                stack.push(num);
            } else if (op.equals("+")) {
                int top = stack.pop();
                int num = top + stack.peek();
                total += num;
                stack.push(top);
                stack.push(num);
            } else {
                int num = Integer.parseInt(op);
                total += num;
                stack.push(num);
            }
        }
        return total;
    }
}