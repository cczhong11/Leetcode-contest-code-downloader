public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> res = new ArrayList<>(dict.size());
        Map<String, List<Integer>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int i = 0, k = 2;
        for (String s : dict) {
            String m = map(s, k);
            List<Integer> list = map.getOrDefault(m, new ArrayList<>());
            list.add(i++);
            if (list.size() == 2) {
                queue.offer(m);
            }
            map.put(m, list);
            res.add(m);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            k++;
            while (size-- > 0) {
                String s = queue.poll();
                List<Integer> list = map.get(s);
                for (int j : list) {
                    String m = map(dict.get(j), k);
                    List<Integer> lists = map.getOrDefault(m, new ArrayList<>());
                    lists.add(j);
                    if (lists.size() == 2) {
                       queue.offer(m);
                    }
                    map.put(m, lists);
                    res.set(j, m);
                }
            }
        }
        return res;
    }
    
    private String map(String s, int k) {
        if (s.length() < k + 2) {
            return s;
        } else {
            String res = s.substring(0, k-1) + (s.length() - k) + s.charAt(s.length() - 1);
            return res.length() < s.length() ? res : s;
        }
    }
}