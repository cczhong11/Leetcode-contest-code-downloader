public class Solution {
    public String solveEquation(String equation) {
        int a = 0;
        int b = 0;
        boolean left = true;
        boolean plus = true;
        for(int i = 0; i < equation.length(); i++) {
            if(equation.charAt(i) == 'x') {
                int cur = 0;
                if(plus)  cur = 1;
                else {
                    cur = -1;
                    plus = true;
                }
                
                
                if(left) a += cur;
                else a -= cur;
            }
            if(equation.charAt(i) == 'x'|| equation.charAt(i) == '+')  continue;
            if(equation.charAt(i) == '=')  left = false;
            if(equation.charAt(i) == '-') {
                plus = false;
            } else if(Character.isDigit(equation.charAt(i))) {
                int num = equation.charAt(i) - '0';
                while(i + 1 < equation.length() && Character.isDigit(equation.charAt(i + 1))) {
                    num = num * 10 + equation.charAt(i + 1) - '0';
                    i++;
                }
                if(i + 1 >= equation.length() || equation.charAt(i + 1) != 'x') {
                    int cur = 0;
                    if(plus) cur = num;
                    else {
                        cur = -num;
                        plus = true;
                    }
                    
                    if(left)  b += cur;
                    else b -= cur;
                }
                
                else {
                    int cur = 0;
                    if(plus) cur = num;
                    else {
                        cur = -num;
                        plus = true;
                    }
                    
                    if(left)  a += cur;
                    else a -= cur;
                    
                    i++;
                }
            }
        }

        if(a == 0 && b != 0)  return "No solution";
        if(a == 0 && b == 0)  return "Infinite solutions";
        else {
            return "x" + "=" + String.valueOf((-b) / a);
        }
        
    }
}