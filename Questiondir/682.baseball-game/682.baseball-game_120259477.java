class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stk = new ArrayDeque<>();
        int sum = 0;
        for (String op : ops) {
            if (op.equals("+")) {
                Integer v2 = stk.pop();
                Integer v1 = stk.pop();
                Integer v3 = v1 + v2;
                stk.push(v1);
                stk.push(v2);
                stk.push(v3);
                sum += v3;
            } else if (op.equals("D")) {
                stk.push(stk.peek() * 2);
                sum += stk.peek();
            } else if (op.equals("C")) {
                sum -= stk.pop();
            } else {
                Integer val = Integer.valueOf(op);
                stk.push(val);
                sum += val;
            }
        }
        return sum;
    }
}