class Solution {
    public String reorganizeString(String str) {
        int k = 2;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> max = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        max.addAll(map.entrySet());
        while (!max.isEmpty()) {
            Map.Entry<Character, Integer> cur = max.remove();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            waitQueue.add(cur);
            if (waitQueue.size() >= k) {
                Map.Entry<Character, Integer> front = waitQueue.remove();
                if (front.getValue() > 0) {
                    max.add(front);
                }
            }
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
}