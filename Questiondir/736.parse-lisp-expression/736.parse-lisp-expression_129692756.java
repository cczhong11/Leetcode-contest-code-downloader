class Solution {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<String, Integer>());
    }
    int evaluate(String expression, Map<String, Integer> map) {
        char startChar = expression.charAt(0);
        if(Character.isDigit(startChar) || startChar=='-') return Integer.parseInt(expression);
        if(startChar >= 'a' && startChar <= 'z') return map.get(expression);
        int []loc = new int[1];
        if(expression.startsWith("add ", 1)) {
            loc[0] = 5;
            String a = getTerm(expression, loc);
            String b = getTerm(expression, loc);
            return evaluate(a, new HashMap<>(map)) + evaluate(b, new HashMap<>(map));
        }
        else if(expression.startsWith("mult ", 1)) {
            loc[0] = 6;
            String a = getTerm(expression, loc);
            String b = getTerm(expression, loc);
            return evaluate(a, new HashMap<>(map)) * evaluate(b, new HashMap<>(map));
        }
        else {
            loc[0] = 5;
            while(loc[0] < expression.length() - 1){
                String key = getTerm(expression, loc);
                if(loc[0] == expression.length() - 1) {
                    return evaluate(key, map);
                }
                String val = getTerm(expression, loc);
                map.put(key, evaluate(val, new HashMap<>(map)));
            }
            return 0;
        }
    }
    
    String getTerm(String expr, int[] b) {
        int begin = b[0];
        if(expr.charAt(begin) == ' ') begin++;
        
        if(expr.charAt(begin) == '('){
            int bal = 0;
            for(int i = begin; i<expr.length()-1; i++) {
                char c = expr.charAt(i);
                if(c == '(') bal++;
                else if(c == ')'){
                    if(--bal == 0){
                        b[0] = i + 1;
                        return expr.substring(begin, i+1);
                    }
                }
            }
        }
        else{
            for(int i = begin; i<expr.length()-1; i++) {
                if(expr.charAt(i) == ' ' || expr.charAt(i)==')'){
                    b[0] = i;
                    return expr.substring(begin, i);
                }
            }
        }
        b[0] = expr.length()-1;
        return expr.substring(begin, expr.length()-1);
    }
}