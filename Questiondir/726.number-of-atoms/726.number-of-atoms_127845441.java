class Solution {
    public String countOfAtoms(String formula) {
        int depth = 0;
        HashMap<Integer, TreeMap<String, Integer>> map = new HashMap<>();
        map.put(0, new TreeMap<>());
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                depth++;
                map.put(depth, new TreeMap<>());
            } else if (c == ')') {
                int beg = ++i;
                if (i < formula.length()) {
                    c = formula.charAt(i);
                    while (c >= '0' && c <= '9') {
                        i++;
                        if (i < formula.length())
                            c = formula.charAt(i);
                        else
                            break;
                    }
                }
                String numStr = formula.substring(beg, i);
                int num = 1;
                if (numStr.length() > 0) {
                    num = Integer.parseInt(numStr);
                }
                TreeMap<String, Integer> oldKV = map.remove(depth);
                TreeMap<String, Integer> currKV = map.get(--depth);
                for (String k : oldKV.keySet()) {
                    currKV.merge(k, num * oldKV.get(k), (x, y) -> x + y);
                }
                i--;
            } else {
                int beg = i;
                i++;
                if (i < formula.length()) {
                    c = formula.charAt(i);
                    while (c >= 'a' && c <= 'z') {
                        i++;
                        if (i < formula.length())
                            c = formula.charAt(i);
                        else
                            break;
                    }
                }
                String ele = formula.substring(beg, i);
                beg = i;
                while (c >= '0' && c <= '9') {
                        i++;
                        if (i < formula.length())
                            c = formula.charAt(i);
                        else
                            break;
                }
                String numStr = formula.substring(beg, i);
                int num = 1;
                if (numStr.length() > 0) {
                    num = Integer.parseInt(numStr);
                }
                map.get(depth).merge(ele, num, (x, y) -> x + y);
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> finalKV = map.get(0);
        for (String s : finalKV.keySet()) {
            sb.append(s + (finalKV.get(s) == 1 ? "" : finalKV.get(s)));
        }
        return sb.toString();
    }
}
