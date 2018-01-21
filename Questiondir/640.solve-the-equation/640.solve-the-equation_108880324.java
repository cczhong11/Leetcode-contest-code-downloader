import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    private long[] parse(String s) {
        long[] res = new long[2];
//        System.out.println(s);
        for (int i = 0; i < s.length(); ) {
            int sign = 1;
            Long val = null;

            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                if (val == null) val = 0L;
                val = val * 10 + s.charAt(i) - '0';
                i++;
            }

            if (val != null) val *= sign;

            if (i < s.length() && s.charAt(i) == 'x') {
                if (val != null) {
                    res[0] += val;
                } else {
                    if (sign == 1) res[0]++;
                    else res[0]--;
                }
                i++;
            } else {
                res[1] += val;
            }
        }
        return res;
    }

    public String solveEquation(String equation) {
        int index = equation.indexOf('=');
        long[] left = parse(equation.substring(0, index));
        long[] right = parse(equation.substring(index + 1));

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        left[0] -= right[0];
        left[1] -= right[1];

        if (left[0] == 0) {
            if (left[1] == 0)
                return "Infinite solutions";
            else
                return "No solution";
        } else {
            return String.format("x=%d", -left[1] / left[0]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(sol.solveEquation("x=x"));
        System.out.println(sol.solveEquation("2x=x"));
        System.out.println(sol.solveEquation("2x+3x-6x=x+2"));
        System.out.println(sol.solveEquation("x=x+2"));
        System.out.println(sol.solveEquation("2=3"));
        System.out.println(sol.solveEquation("2=2"));
        System.out.println(sol.solveEquation("0x=0"));
    }
}