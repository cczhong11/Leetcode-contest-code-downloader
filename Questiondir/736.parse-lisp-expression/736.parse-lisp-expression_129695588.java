class Solution {
    public int evaluate(String expression) {
        List<HashMap<String, Integer>> list = new ArrayList<>();
        return eval(list, 0, expression);
    }
    
    int eval(List<HashMap<String, Integer>> list, int level, String exp) {
        if (exp == null || exp.length() == 0) {
            return 0;
        }
        if (exp.charAt(0) != '(') {
            if (Character.isLetter(exp.charAt(0))) {
                for (int i = level - 1; i >= 0; i--) {
                    HashMap<String, Integer> map = list.get(i);
                    if (map.containsKey(exp)) {
                        return map.get(exp);
                    }
                }
                return 0;
            } else {
                return Integer.parseInt(exp);
            }
        } else {
            HashMap<String, Integer> map = new HashMap<>();
            if (level == list.size()) {
                list.add(map);
            } else {
                list.set(level, map);
            }
            int len = exp.length();
            exp = exp.substring(1, len - 1);
            if (exp.charAt(0) == 'a') {
                int idx1 = 4;
                int idx2 = find(idx1, exp);
                int idx3 = find(idx2 + 1, exp);
                int v1 = eval(list, level + 1, exp.substring(idx1, idx2));
                int v2 = eval(list, level + 1, exp.substring(idx2 + 1, idx3));
                // System.out.println(idx2 + ", " + idx3);
                return v1 + v2;
            } else if (exp.charAt(0) == 'm') {
                int idx1 = 5;
                int idx2 = find(idx1, exp);
                int idx3 = find(idx2 + 1, exp);
                int v1 = eval(list, level + 1, exp.substring(idx1, idx2));
                int v2 = eval(list, level + 1, exp.substring(idx2 + 1, idx3));
                return v1 * v2;
            } else if (exp.charAt(0) == 'l') {
                int idx = 4;
                while (idx < exp.length()) {
                    int idx1 = idx;
                    int idx2 = find(idx1, exp);
                    int idx3 = find(idx2 + 1, exp);
                     
                    if (idx3 <= idx2 + 1) {
                        return eval(list, level + 1, exp.substring(idx1, idx2));
                    }
                    int v2 = eval(list, level + 1, exp.substring(idx2 + 1, idx3));
                    map.put(exp.substring(idx1, idx2), v2);
                    idx = idx3 + 1;
                }
                return 0;
            } else {
                return 0;
            }
        }
    }
    
    int find(int idx, String exp) {
        int open = 0;
        for (int i = idx; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                open--;
            } else if (c == ' ') {
                if (open == 0) {
                    return i;
                }
            }
        }
        return exp.length();
    }
}