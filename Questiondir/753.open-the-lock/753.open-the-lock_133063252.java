class Solution {
    class Pair {
        String key;
        int depth;
        Pair(String k, int d) {
            key = k;
            depth = d;
        }
    }
    public int openLock(String[] deadends, String target) {
        Set<String> d = new HashSet<>();
        for (String s : deadends)
            d.add(s);
        List<Pair> q = new ArrayList<>();
        Set<String> v = new HashSet<>();
        if (!d.contains("0000")) {
            q.add(new Pair("0000", 0));
            v.add("0000");
        }
        while (!q.isEmpty()) {
            Pair p = q.remove(0);
            String k = p.key;
            //System.out.println(k + " " + p.depth);
            if (k.equals(target))
                return p.depth;
            for (int i = 0; i < 4; i++) {
                char c = k.charAt(i);
                char newC1 = c == '9' ? '0' : (char)(c + 1);
                char newC2 = c == '0' ? '9' : (char)(c - 1);
                String newK1 = k.substring(0, i) + newC1 + k.substring(i + 1);
                String newK2 = k.substring(0, i) + newC2 + k.substring(i + 1);
                if (!d.contains(newK1) && !v.contains(newK1)) {
                    q.add(new Pair(newK1, p.depth + 1));
                    v.add(newK1);
                }
                if (!d.contains(newK2) && !v.contains(newK2)) {
                    q.add(new Pair(newK2, p.depth + 1));
                    v.add(newK2);
                }
            }
        }
        return -1;
    }
}