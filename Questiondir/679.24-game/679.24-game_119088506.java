class Solution {
    public boolean judgePoint24(int[] nums) {
        char[] ops = {'+','-','*','/'};
        List<Double> list = new ArrayList<>();
        for(int n : nums) {
            list.add((double) n);
        }
        
        return check(list, ops);
        
        
    }
    
    public boolean check(List<Double> list, char[] ops) {
        if(list.size() < 2) {
            return list.get(0) == 24;
        }
        
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                for(int k = 0; k < 4; k++) {
                    List<Double> newList = new ArrayList<>(list);
                    double a = newList.get(i);
                    double b = newList.get(j);
                    newList.remove(j);
                    newList.remove(i);
                    char op = ops[k];
                    double res1 = calculate(a, b, op);
                    double res2 = calculate(b,a,op);
                    newList.add(res1);
                    if(check(newList, ops)) {
                        return true;
                    }
                    newList.remove(newList.size() - 1 );
                    newList.add(res2);
                    if(check(newList, ops)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public double calculate(double a, double b, char op) {
        if(op == '+') {
            return a + b;
        } else if(op == '-') {
            return a - b;
        } else if(op == '*') {
            return a*b;
        } else {
            if(b == 0) {
                return 10000000;
            }
            return a / b;
        }
    }
}