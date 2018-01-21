public class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] r1 = solve(parts[0]);
        int[] r2 = solve(parts[1]);
        int x = r1[0] - r2[0];
        int c = r2[1] - r1[1];
        if (x == 0) {
            if (c == 0) return "Infinite solutions";
            return "No solution";
        }
        return "x=" + (c / x);
    }
    int[] solve(String s) {
        String[] ps = s.split("[+-]");
        int len = -1;
        int x = 0, c = 0;
        for (String p : ps) {
            if (p.length() == 0) {
                len++;
                continue;
            }
            int index = p.indexOf('x');
            if (index != -1) {
                int eff = index == 0 ? 1 : Integer.parseInt(p.substring(0, index));
                if (len >= 0 && s.charAt(len) == '-') eff = -eff;
                x += eff;
            } else {
                int eff = Integer.parseInt(p);
                if (len >= 0 && s.charAt(len) == '-') eff = -eff;
                c += eff;                
            }
            len += p.length() + 1;
        }
        return new int[] { x, c };
    }
}