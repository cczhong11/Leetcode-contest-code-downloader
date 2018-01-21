class Solution {
    
    int idx = 0;
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.putAll(helper(formula, 0));
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key);
            if (map.get(key) > 1) {
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }
    
    private Map<String, Integer> helper(String s, int i) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == ')') {
                if (sb.length() > 0) map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                int k = j + 1;
                int cnt = 0;
                for (; k < s.length(); k++) {
                    if (!Character.isDigit(s.charAt(k))) break;
                    cnt = 10 * cnt + s.charAt(k) - '0';
                }  
                cnt = Math.max(1, cnt);
                for (String key : map.keySet()) {
                    map.put(key, map.get(key) * cnt);
                }
                idx = k - 1;
                return map;
            }
            if (c == '(') {
                if (sb.length() > 0) map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                Map<String, Integer> ret = helper(s, j + 1);
                for (String k : ret.keySet()) {
                    map.put(k, map.getOrDefault(k, 0) + ret.get(k));
                }   
                j = idx;
                sb.setLength(0);
            } else if (c >= 'A' && c <= 'Z') {
                if (sb.length() > 0) map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                sb = new StringBuilder();
                sb.append(c);
                //System.out.println(sb);
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                int cnt = c - '0';
                int k = j + 1;
                for (; k < s.length(); k++) {
                    if (Character.isDigit(s.charAt(k))) cnt = 10 * cnt + s.charAt(k) - '0';
                    else break;
                }
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + cnt);
                sb.setLength(0);
                j = k - 1;
            }
        }
        
        if (sb.length() > 0) map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        return map;
    }
}