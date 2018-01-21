import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.evaluate("(add 1 2)"));
        System.out.println(sol.evaluate("0"));
        System.out.println(sol.evaluate("123"));
        System.out.println(sol.evaluate("-123"));
        System.out.println(sol.evaluate(" (mult 3 (add 2 3))"));
        System.out.println(sol.evaluate("(let x 2 (mult x 5))"));
        System.out.println(sol.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        System.out.println(sol.evaluate("(let x 3 x 2 x)"));
        System.out.println(sol.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        System.out.println(sol.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
        System.out.println(sol.evaluate("(let a1 3 b2 (add a1 1) b2) "));
    }

    String s;
    int ptr = 0;
    Map<String, Stack<Integer>> vars;


    String next() {
        while (ptr < s.length() && s.charAt(ptr) == ' ') ptr++;

        if (s.charAt(ptr) == '(' || s.charAt(ptr) == ')') return s.charAt(ptr++) + "";

        StringBuilder builder = new StringBuilder();
        while (ptr < s.length() && s.charAt(ptr) != '(' && s.charAt(ptr) != ')' && s.charAt(ptr) != ' ')
            builder.append(s.charAt(ptr++));
        return builder.toString();
    }

    boolean isLastExpr() {
        int i;
        for (i = ptr; i < s.length(); i++) {
            if (s.charAt(i) == ' ') return false;
            else if (s.charAt(i) == ')') break;
        }

        if (s.charAt(i) != ')') throw new RuntimeException(")");

        return true;
    }

    int dfs() {
        String token = next();
//        System.out.println(ptr);
//        System.out.println(token);
        int ans = 0;
        if (token.charAt(0) != '(') {
            try {
                ans = Integer.parseInt(token);
            } catch (Exception e) {
                ans = vars.get(token).peek();
            }
        } else {
            token = next();
//            System.out.println(token);

            if (token.equals("add")) {
                ans = dfs() + dfs();
            } else if (token.equals("mult")) {
                ans = dfs() * dfs();
            } else {
                Stack<String> stack = new Stack<>();

                String key = next();
                while (true) {
                    int val = dfs();

                    stack.push(key);
                    vars.putIfAbsent(key, new Stack<>());
                    vars.get(key).push(val);

                    while (ptr < s.length() && s.charAt(ptr) == ' ') ptr++;
                    if (Character.isLowerCase(s.charAt(ptr)) && !isLastExpr()) {
                        key = next();
                        continue;
                    } else {
                        break;
                    }
                }

                ans = dfs();
                while (!stack.isEmpty()) {
                    vars.get(stack.pop()).pop();
                }
            }
            next(); // eat )
        }

        return ans;
    }


    public int evaluate(String expression) {
        ptr = 0;
        s = expression.trim();
        vars = new HashMap<>();
        return dfs();
    }
}