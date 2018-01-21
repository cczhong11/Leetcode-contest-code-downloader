public class Solution {
    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    public boolean isPossible(int[] nums) {
        for(int n : nums) {
            if (map.containsKey(n-1)) {
                PriorityQueue<Integer> que = map.get(n-1);
                int len = que.poll();
                if (que.size()==0) map.remove(n-1);
                add2map(n, len+1);
            } else {
                add2map(n, 1);
            }
        }
        
        for(int key : map.keySet()) {
            int len = map.get(key).poll();
            if (len < 3) return false;
        }
        return true;
    }
    
    private void add2map(int key, int len) {
        PriorityQueue<Integer> que = map.get(key);
        if (que == null) que = new PriorityQueue<>();
        que.add(len);
        map.put(key, que);
    }
}