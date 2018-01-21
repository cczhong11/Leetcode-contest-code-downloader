class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack();
        
        Map<String, Integer> cur = new HashMap();
        System.out.println(" i ");
        for (int i = 0; i < formula.length(); ) {
            System.out.println(" i "+i);
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.push(cur);
                cur = new HashMap();
                i++;
            } else if (ch == ')') {
                int j = i+1;
                int time = 1;
                Map<String, Integer> past = stack.pop();
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) j++;
                if (j > i+1) {
                    time = Integer.parseInt(formula.substring(i+1, j));
                }
                for (String key: cur.keySet()) {
                    past.put(key, past.getOrDefault(key, 0)+cur.get(key)*time);
                }
                cur = past;
                i = j;
            } else {
                int j = i+1;
                int time = 1;
                while (j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') j++;
                String name = formula.substring(i, j);
                int k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                if (k > j) {
                    time = Integer.parseInt(formula.substring(j, k));
                }
                cur.put(name, cur.getOrDefault(name, 0)+time);
                i = k;
            }
            System.out.println(" i' "+i);
        }
        List<String> keys = new ArrayList(cur.keySet());
        StringBuilder sb = new StringBuilder();
        Collections.sort(keys);
        for (String key: keys) {
            sb.append(key);
            if (cur.get(key) > 1) sb.append(cur.get(key));
        }
        return sb.toString();
        
    }
}