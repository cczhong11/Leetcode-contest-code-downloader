public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n <= 0) {
            return tasks.length;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char temp : tasks) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) -> (b.getValue() - a.getValue()));
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }
        
        int total = 0;
        while (!heap.isEmpty()) {
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            
            for (int i = 0; i <= n; i++) {
                
                if (heap.isEmpty()) {
                    if (list.isEmpty()) {
                        break;
                    } else {
                        total++;
                    }
                } else {
                    Map.Entry<Character, Integer> entry = heap.poll();
                    if (entry.getValue() > 1) {
                        entry.setValue(entry.getValue() - 1);
                        list.add(entry);
                    }
                    total++;
                }
            }
            
            for (int i = 0; i < list.size(); i++) {
                heap.add(list.get(i));
            }
            
        }
        
        return total;
    }
}