class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<String>();
        HashSet<String> visited = new HashSet<String>();
        for (String s: deadends)
            set.add(s);
        Queue<String> q = new LinkedList<String>();
        q.offer("0000");
        int count = 1, count_next = 0, step = 0;
        while (q.size() > 0) {
            String s = q.poll();
            if (s.equals(target)) return step;
            count--;
            if (!set.contains(s)) {
                for (int i = 0; i < 4; i++) {
                    StringBuilder next = new StringBuilder(s);
                    char c = s.charAt(i);
                    char cplus = (c == '9')? '0' : (char)(c + 1);
                    char cminus = (c == '0')? '9' : (char)(c - 1);
                    next.setCharAt(i, cplus);
                    String np = next.toString();
                    if (!visited.contains(np)) {
                        visited.add(np);
                        count_next++;
                        q.offer(np);
                    }
                    next.setCharAt(i, cminus);
                    String nm = next.toString();
                    if (!visited.contains(nm)) {
                        visited.add(nm);
                        count_next++;
                        q.offer(nm);
                    }
                }
            }
            if (count == 0) {
                step++;
                count = count_next;
                count_next = 0;
            }
        }
        return -1;
    }
    
}