public class AutocompleteSystem {

    Map<String, Integer> map;
    StringBuilder sb = new StringBuilder();
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        for(int i = 0; i < sentences.length; ++ i) {
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            String s = sb.toString();
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
            sb.setLength(0);
            return Arrays.asList();
        }
        else {
            sb.append(c);
            String s = sb.toString();
            PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) ->
            {
                int c1 = map.getOrDefault(s1, 0);
                int c2 = map.getOrDefault(s2, 0);
                if(c1 != c2) {
                    return c1 < c2 ? -1 : 1;
                }
                else {
                    return - s1.compareTo(s2);
                }
            });
            for(String key : map.keySet()) {
                if(key.startsWith(s)) {
                    queue.add(key);
                }
                if(queue.size() > 3) {
                    queue.poll();
                }
            }
            List<String> a = new ArrayList<>();
            while (!queue.isEmpty()) {
                a.add(queue.poll());
            }
            return reverse(a);
        }
    }

    List<String> reverse(List<String> a) {
        for(int i = 0, j = a.size() - 1; i < j; ++ i, -- j) {
            String tmp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, tmp);
        }
        return a;
    }
}


/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */