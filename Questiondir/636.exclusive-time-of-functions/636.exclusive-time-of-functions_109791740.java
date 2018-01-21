public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int s = 0, id = -1;
        for (String log : logs) {
            String[] ps = log.split(":");
            int e = Integer.parseInt(ps[2]);
            if (ps[1].equals("start")) {
                stack.push(id);
                if (id != -1 && !map.containsKey(id)) {
                    map.put(id, 0);
                }
                if (id != -1) map.put(id, map.get(id) + e - s);
                s = e;
                id = Integer.parseInt(ps[0]);
            } else {
                e++;
                if (id != -1 && !map.containsKey(id)) map.put(id, 0);
                if (id != -1) map.put(id, map.get(id) + e - s);
                s = e;
                id = stack.pop();
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(i);
        }
        return res;
    }
}