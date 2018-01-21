class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> rounds = new Stack<>();
        int sum = 0;
        for (String op:ops){
            if (op.equals("+")){
                int last = rounds.pop();
                int thisRound = last + rounds.peek();
                rounds.push(last);
                rounds.push(thisRound);
                sum+=thisRound;
            }
            else if (op.equals("D")){
                int thisRound = rounds.peek() * 2;
                rounds.push(thisRound);
                sum+=thisRound;
            }
            else if (op.equals("C")){
                sum -= rounds.pop();
            }
            else{
                rounds.push(Integer.valueOf(op));
                sum += rounds.peek();
            }
        }
        
        return sum;
    }
}