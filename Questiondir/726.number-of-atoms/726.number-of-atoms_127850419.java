class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> freq = helper(formula);
        List<Map.Entry<String, Integer>> elems = new ArrayList<>(freq.entrySet());
        Collections.sort(elems, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> elem : elems) {
            if (elem.getValue() > 1) result.append(elem.getKey() + elem.getValue());
            else result.append(elem.getKey());
        }
        return result.toString();
    }
    
    private static Map<String, Integer> helper(String formula) {
        Map<String, Integer> freq = new HashMap<>();
        Stack<Map<String, Integer>> current = new Stack<>();
        current.push(freq);
        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                i++;
                current.push(new HashMap<>());
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> f = current.pop();
                i++;
                int count = 0;
                while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                    count *= 10;
                    count += formula.charAt(i) - '0';
                    i++;
                }
                if (count == 0) count = 1;
                System.out.println("Whole map has count " + count);
                for (Map.Entry<String, Integer> e : f.entrySet()) {
                    if (!current.peek().containsKey(e.getKey())) current.peek().put(e.getKey(), 0);
                    current.peek().put(e.getKey(), current.peek().get(e.getKey()) + count * e.getValue());
                }
            } else {
                StringBuilder element = new StringBuilder();
                if (i < formula.length() && formula.charAt(i) >= 'A' && formula.charAt(i) <= 'Z') {
                    element.append(formula.charAt(i));
                    i++;
                }
                while (i < formula.length() && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
                    element.append(formula.charAt(i));
                    i++;
                }
                int count = 0;
                while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                    count *= 10;
                    count += formula.charAt(i) - '0';
                    i++;
                }
                if (count == 0) count = 1;
                String name = element.toString();
                if (!current.peek().containsKey(name)) current.peek().put(name, 0);
                current.peek().put(name, current.peek().get(name) + count);
            }
        }
        return freq;
    }
}