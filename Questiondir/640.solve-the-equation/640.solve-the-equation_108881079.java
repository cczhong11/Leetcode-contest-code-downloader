public class Solution {
    public String solveEquation(String equation) {
        String[] expressions = equation.split("=");
        if (expressions.length != 2) {
            return "Infinite solutions";
        }

        double[] left = evaluate(expressions[0]);
        double[] right = evaluate(expressions[1]);

        double coef = left[0] - right[0];
        double constant = right[1] - left[1];

        if (coef == 0) {
            if (constant == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + (int) (constant / coef);
        }
    }

    private double[] evaluate(String expression) {
        double coef = 0;
        double constant = 0;

        if (!expression.startsWith("-") && !expression.startsWith("+")) {
            expression = "+" + expression;
        }

        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == 'x') {
                if (start == i - 1) {
                    if (expression.charAt(start) == '+') {
                        coef += 1;
                    } else {
                        coef -= 1;
                    }
                } else {
                    double d = Double.parseDouble(expression.substring(start, i));
                    coef += d;
                }

                start = i + 1;
            } else if (c == '-' || c == '+') {
                if (i != start) {
                    double d = Double.parseDouble(expression.substring(start, i));
                    constant += d;
                    start = i;
                }
            }
        }

        if (start != expression.length()) {
            constant += Double.parseDouble(expression.substring(start));
        }

        return new double[] { coef, constant };
    }
}