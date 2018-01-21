public class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> count = new HashMap<>();
        
        for (char t: tasks) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        
        Comparator<Character> cmp = new Comparator<Character>(){
            public int compare(Character c1, Character c2) {
                return count.get(c2) - count.get(c1);
            }
        };
        PriorityQueue<Character> heap = new PriorityQueue<>(cmp);
        ArrayDeque<Character> queue = new ArrayDeque<>();
        
        for (char c: count.keySet()) {
            heap.add(c);
        }
        
        int res = 0;
        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0;; i++) {
            if (queue.isEmpty() && heap.isEmpty()) {
                return i;
            }
            
            if (!queue.isEmpty() && i > pos.get(queue.peek())) {
                heap.add(queue.poll());
                
            }
            
            if (!heap.isEmpty()) {
                char c = heap.poll();
                count.put(c, count.get(c) - 1);
                if (count.get(c) > 0) {
                    queue.offer(c);
                    pos.put(c, i + n);
                }
            } else {
                res++;
            }
        }
    }
}