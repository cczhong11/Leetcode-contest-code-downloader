import java.util.Arrays;

public class Solution {
    public String solveEquation(String equation) {
        equation = equation.replace("+", " +").replace("-", " -").replace("=", " = ");
        String[] items = equation.split(" +");
        long mul = 1;
        long coefficient = 0;
        long constant = 0;
        System.out.println(Arrays.toString(items));
        for (String item : items) {
            if (item.isEmpty()) {
                continue;
            }
            item = item.trim();
            if (item.contains("=")) {
                mul = -1;
            } else if (item.contains("x")) {
                item = item.substring(0, item.length() - 1);
                if (item.isEmpty() || item.equals("+") || item.equals("-") || !Character.isDigit(item.charAt(item.length() - 1))) {
                    item += "1";
                }
                long l = item.isEmpty() ? 0 : Long.parseLong(item);
                coefficient += mul * l;
            } else {
                constant += mul * Long.parseLong(item);
            }
        }
        if (coefficient == 0) {
            if (constant == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + (-constant / coefficient);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("-x=-1"));
    }
}