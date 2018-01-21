class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (String op : ops) {
            int top;
            int toAdd;
            switch (op) {
                case "C":
                    top = stack.pop();
                    score -= top;
                    break;
                case "D":
                    top = stack.peek();
                    stack.push(top * 2);
                    score += top * 2;
                    break;
                case "+":
                    top = stack.pop();
                    toAdd = top + stack.peek();
                    stack.push(top);
                    stack.push(toAdd);
                    score += toAdd;
                    break;
                default:
                    toAdd = Integer.parseInt(op);
                    score += toAdd;
                    stack.push(toAdd);
            }
        }
        return score;
    }
}