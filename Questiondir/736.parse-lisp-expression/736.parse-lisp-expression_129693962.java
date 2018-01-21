class Solution {

    public int evaluate(String expression) {
        Map<String, Integer> varMap = new HashMap<>();
        return cal(varMap, expression);
    }

    int cal(Map<String, Integer> varMap, String exp) {
        varMap = new HashMap<>(varMap);
        if (exp.charAt(0) == '(') exp = exp.substring(1, exp.length()-1);

        if (exp.startsWith("add ")) {
            String a = getUnit(exp.substring(4));
            String b = getUnit(exp.substring(4+a.length()+1));
            return cal(varMap, a) + cal(varMap, b);

        } else if (exp.startsWith("mult ")) {
            String a = getUnit(exp.substring(5));
            String b = getUnit(exp.substring(5+a.length()+1));
            return cal(varMap, a) * cal(varMap, b);

        } else if (exp.startsWith("let ")) {
            int index = 4;
            while (index < exp.length()) {
                String x = getUnit(exp.substring(index));
                if (x.length() + index == exp.length()) {
                    return cal(varMap, x);
                } else {
                    String v = getUnit(exp.substring(index + x.length() + 1));
                    int val = cal(varMap, v);
                    varMap.put(x, val);
                    index += x.length() + v.length() + 2;
                }
            }
        } else {
            return varMap.containsKey(exp) ? varMap.get(exp) : Integer.valueOf(exp);
        }

        return 0;
    }

    String getUnit(String str) {
        if (str.charAt(0) != '(') {
            int end = str.indexOf(" ");
            return end >= 0 ? str.substring(0, end) : str;
        } else {
            int count = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == '(') count++;
                else if (str.charAt(i) == ')') count--;

                if (count==0) {
                    return str.substring(0, i+1);
                }
            }
        }
        return "";
    }

}