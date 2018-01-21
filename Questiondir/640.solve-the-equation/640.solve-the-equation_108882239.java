public class Solution {
    public String solveEquation(String equation) {
        String[] s = equation.split("=");
        int[] left = helper(s[0]);
        int[] right = helper(s[1]);
        if (left[0] == right[0] && left[1] == right[1]) return "Infinite solutions";
        if (left[0] == right[0] && left[1] != right[1]) return "No solution";
        return "x=" + (left[1] - right[1])/(right[0] - left[0]);
    }
    
    public int[] helper(String s) {
        s = s.replaceAll("\\s+","");
        int constant = 0;
        int coeff = 0;
        int sign = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '-') {
                if (sign == 0 || sign == 1) sign = -1;
                else sign = 1;
            }
            else if (cur == '+') {
                if (sign == 1 || sign == 0) sign = 1;
                else sign = -1;
            }
            else if (Character.isDigit(cur)) {
                sb.append(cur);
                if (i + 1 == s.length() || (s.charAt(i + 1) != 'x' && !Character.isDigit(s.charAt(i + 1)))) {
                    constant += Integer.parseInt(sb.toString()) * sign;
                    sign = 0;
                    sb = new StringBuilder();
                }
            }
            else if (cur == 'x') {
                if (sb.length() == 0) coeff += sign;
                else coeff += Integer.parseInt(sb.toString()) * sign;
                sign = 0;
                sb = new StringBuilder();
            }
        }
        return new int[] {coeff, constant};
    }
}