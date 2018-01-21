class Solution {
   public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int num = num1 + num2;
                stack.push(num1);
                stack.push(num2);
                stack.push(num);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                int num = Integer.parseInt(op);
                stack.push(num);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}