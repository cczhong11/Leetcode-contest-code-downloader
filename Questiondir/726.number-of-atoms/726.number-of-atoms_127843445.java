class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> res = new TreeMap();
        int i = 0;
        Stack<Map> s = new Stack();
        Map<String, Integer> curr = res;
        while (true){
            if (i == formula.length()) break;
            char c = formula.charAt(i);
            if (c == '('){
                s.push(curr);
                curr = new TreeMap();
                i++;
            }
            else if (c == ')'){
                i++;
                int count = 0;
                while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9'){
                    count = (formula.charAt(i) - '0') + count * 10;
                    i++;
                }
                count = Math.max(count, 1);
                Map<String, Integer> next = s.pop();
                for (String element: curr.keySet()) next.put(element, next.getOrDefault(element, 0) + count * curr.get(element));
                curr = next;
            }
            else{
                int start_char = i, end_char = i + 1;
                while (end_char < formula.length() && formula.charAt(end_char) >= 'a' && formula.charAt(end_char) <= 'z') end_char++;
                i = end_char;
                int count = 0;
                while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9'){
                    count = (formula.charAt(i) - '0') + count * 10;
                    i++;
                }
                count = Math.max(count, 1);
                String element = formula.substring(start_char, end_char);
                curr.put(element, curr.getOrDefault(element, 0) + count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String element: curr.keySet()){
            sb.append(element);
            if (curr.get(element) != 1) sb.append(curr.get(element));
        }
        return sb.toString();
    }
}