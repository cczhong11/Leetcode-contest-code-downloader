class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : ops) {
            if (s.equals("C")) {
                sum -= stack.pop();
            } else if (s.equals("D")) {
                int temp = 2 * stack.peek();
                sum += temp;
                stack.push(temp);
            } else if (s.equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.peek();
                stack.push(temp1);
                int val = temp1 + temp2;
                stack.push(val);
                sum += val;
            } else {
                int val = Integer.parseInt(s);
                stack.push(val);
                sum += val;
            }
        }
        return sum;
    }
}