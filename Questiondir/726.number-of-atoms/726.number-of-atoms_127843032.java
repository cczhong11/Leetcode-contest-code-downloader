class Solution {
    int i = 0;

    public String countOfAtoms(String formula) {
        i = 0;
        TreeMap<String, Integer> map = parse(formula);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if(entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    TreeMap<String, Integer> parse(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for(; i < formula.length(); ) {
            if(formula.charAt(i) == ')') {
                ++ i;
                break;
            }
            else if(formula.charAt(i) == '(') {
                ++ i;
                TreeMap<String, Integer> subMap = parse(formula);
                int r = 0;
                for(; i < formula.length() && Character.isDigit(formula.charAt(i)); ++ i) {
                    r = r * 10 + formula.charAt(i) - '0';
                }
                if(r == 0) {
                    r = 1;
                }
                for(Map.Entry<String, Integer> entry : subMap.entrySet()) {
                    if(!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), 0);
                    }
                    map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue() * r);
                }
            }
            else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i ++));
                for(; i < formula.length() && Character.isLowerCase(formula.charAt(i)); ++ i) {
                    element.append(formula.charAt(i));
                }

                int r = 0;
                for(; i < formula.length() && Character.isDigit(formula.charAt(i)); ++ i) {
                    r = r * 10 + formula.charAt(i) - '0';
                }
                if(r == 0) {
                    r = 1;
                }
                String key = element.toString();
                if(!map.containsKey(key)) {
                    map.put(key, 0);
                }
                map.put(key, map.get(key) + r);
            }
        }
        return map;
    }
}