class Solution {
    private Map<String, List<Character>> map;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new HashMap<>();
        for (String a: allowed) {
            String key = a.substring(0, 2);
            char val = a.charAt(2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(val);
        }
        return help(new StringBuilder(bottom));
    }
    private boolean help(StringBuilder sb) {
        if (sb.length() == 1) return true;
        Queue<StringBuilder> q = new LinkedList<>();
        q.add(new StringBuilder());
        for (int i = 0; i < sb.length() - 1; i++) {
            String temp = sb.substring(i, i + 2);
            if (!map.containsKey(temp)) return false;
            List<Character> tl = map.get(temp);
            int size = q.size();
            for (int j = 0; j < size; j++) {
                StringBuilder tsb = q.poll();
                for (Character c: tl)
                    q.add(new StringBuilder(tsb).append(c));
            }
        }
        while (q.size() > 0) {
            if (help(q.poll())) return true;
        }
        return false;
    }
}