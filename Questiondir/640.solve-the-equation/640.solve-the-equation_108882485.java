public class Solution {
    public String solveEquation(String equation) {
        List<String> tokens = new ArrayList<>();

        int idx1 = 0;
        for (int i = 0 ; i < equation.length(); i++) {
            if (!Character.isDigit(equation.charAt(i))) {
                tokens.add(equation.charAt(i) + "");
                idx1 = i + 1;
            } else if (i == equation.length() - 1 || !Character.isDigit(equation.charAt(i + 1))) {
                tokens.add(equation.substring(idx1, i + 1));
                idx1 = i + 1;
            }
        }
        int[] eq1 = new int[2];
        int[] eq2 = new int[2];

        int[] curEq = eq1;
        for (int i = 0 ; i <tokens.size(); i++) {
            String cur = tokens.get(i);
            if (cur.equals("+") || cur.equals("-")) continue;
            if (cur.equals("=")) {
                curEq = eq2;
                continue;
            }

            int sign = 1;
            if (i > 0) {
                if (tokens.get(i - 1).charAt(0) == '-') {
                    sign = -1;
                }
            }

            if (cur.equals("x")) {
                char prev = 1;
                if (i > 0) prev = tokens.get(i - 1).charAt(0);
                if (!Character.isDigit(prev)) {
                    curEq[0] += sign;
                }
            } else {
                if (i + 1 < tokens.size() && tokens.get(i + 1).equals("x")) {
                    curEq[0] += sign * Integer.parseInt(cur);
                } else {
                    curEq[1] += sign * Integer.parseInt(cur);
                }
            }
        }

        eq1[0] -= eq2[0];
        eq1[1] -= eq2[1];

        if (eq1[0] == 0 && eq1[1] != 0) {
            return "No solution";
        }
        try {
            eq1[1] /= eq1[0]; // simplify
        } catch (Exception e) {
            return "Infinite solutions";
        }
        eq1[1] *= -1; //flip sign
        return "x=" + eq1[1] + "";
    }
}