class Solution {
    
    private class Entry implements Comparable<Entry> {
        
        int tmp;
        int ind;
        
        public Entry(int t, int i) {
            
            tmp = t;
            ind = i;
            
        }
        
        public int compareTo(Entry e) {
            
            return tmp - e.tmp;
            
        }
        
    }
    
    public int[] dailyTemperatures(int[] temperatures) {
        
        // the next greater element
        int n = temperatures.length;
        // Entry[] arrays = new Entry[n];
        int[] res = new int[n];
        
        Queue<Entry> pq = new PriorityQueue<Entry>();
                    
        for (int i = 0; i < n; ++i) { 
            
            Entry cur = new Entry(temperatures[i], i);
            while (!pq.isEmpty() && pq.peek().tmp < cur.tmp) {
                
                Entry top = pq.poll();
                res[top.ind] = i - top.ind;
                
            }
            pq.add(cur);
        
        }
        
        return res;
        
    }
}