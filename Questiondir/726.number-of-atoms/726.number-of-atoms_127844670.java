class Solution {

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> countMap = count(formula);

        String ans = "";
        for (String name : countMap.keySet()) {
            ans += name;
            if (countMap.get(name) > 1) ans += String.valueOf(countMap.get(name));
        }
        return ans;
    }

    TreeMap<String, Integer> count(String formula) {
        TreeMap<String, Integer> countMap = new TreeMap<>();
        if (formula.isEmpty()) return countMap;

        int len = formula.length();
        int index = 0;
        while (index < len) {
            char ch = formula.charAt(index);
            int start = index;
            if (ch >= 'A' && ch <= 'Z') {
                index++;
                while (index < len) {
                    if (formula.charAt(index) < 'a' || formula.charAt(index) > 'z') {
                        break;
                    }
                    index++;
                }

                String name = formula.substring(start, index);
                int num = 1;
                if (index < len && isDigit(formula.charAt(index))) {
                    num = formula.charAt(index) - '0';
                    index++;
                    while (index < len && isDigit(formula.charAt(index))) {
                        num = num * 10 + formula.charAt(index) - '0';
                        index++;
                    }
                }

                add(countMap, name, num);

            } else { // (
                index++;
                int pCount = 1;
                while (index < len) {
                    if (formula.charAt(index) == '(') pCount++;
                    else if (formula.charAt(index) == ')') pCount--;

                    if (pCount == 0) {
                        break;
                    }
                    index++;
                }

                String subFormula = formula.substring(start+1, index);
                TreeMap<String, Integer> subCountMap = count(subFormula);
                index++;

                int times = 1;
                if (index < len && isDigit(formula.charAt(index))) {
                    times = formula.charAt(index) - '0';
                    index++;
                    while (index < len && isDigit(formula.charAt(index))) {
                        times = times * 10 + formula.charAt(index) - '0';
                        index++;
                    }
                }

                for (String name : subCountMap.keySet()) {
                    int num = subCountMap.get(name) * times;
                    add(countMap, name, num);
                }
            }
        }

        return countMap;

    }
    
    void add(TreeMap<String, Integer> countMap, String name, int num) {
        if (countMap.containsKey(name)) {
            countMap.put(name, countMap.get(name) + num);
        } else {
            countMap.put(name, num);
        }
    }

    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}