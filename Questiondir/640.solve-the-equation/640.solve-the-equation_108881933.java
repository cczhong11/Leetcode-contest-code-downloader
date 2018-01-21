public class Solution {
     public String solveEquation(String equation) {
        String[] expr = equation.split("=");
        Expr left = new Expr(expr[0]);
        Expr right = new Expr(expr[1]);
        if (left.coff == right.coff) {
            if (left.consts == right.consts) return "Infinite solutions";
            else return "No solution";
        } else
            return "x=" + ((right.consts - left.consts) / (left.coff - right.coff));
    }

    

    private static class Expr {
        int coff = 0;
        int consts = 0;

        public Expr(String s) {
            int l = s.length(), i = 0;
            boolean pos = true;
            if (s.charAt(0) == '+') i++;
            if (s.charAt(0) == '-') {
                i++;
                pos = false;
            }
            for (; i < l; ) {
                int start = i;
                while (i < l && s.charAt(i) != '+' && s.charAt(i) != '-') i++;
                if (s.charAt(i - 1) == 'x') {
                    coff += (pos ? 1 : -1) * (start == i - 1 ? 1 : Integer.valueOf(s.substring(start, i - 1)));
                } else {
                    consts += (pos ? 1 : -1) * Integer.valueOf(s.substring(start, i));
                }
                if (i < l && s.charAt(i) == '+') pos = true;
                else pos = false;
                i++;
            }
        }
    }
}