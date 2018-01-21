/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
    
        Comparator<Interval> cmptor1 = new Comparator<Interval>() {
            
            public int compare(Interval i1, Interval i2) {
                
                return i1.start - i2.start;
                
            }
            
        };
        
        Comparator<Interval> cmptor2 = new Comparator<Interval>() {
            
            public int compare(Interval i1, Interval i2) {
                
                return i2.end - i1.end;
                
            }
            
        };
        
        
        List<Interval> itvs = new ArrayList<Interval>();
        
        for (List<Interval> list: avails) {
            for (Interval tmp: list) itvs.add(tmp);
            
        }
        
        Collections.sort(itvs, cmptor1);
        Queue<Interval> pq = new PriorityQueue<Interval>(cmptor2);
        
        int ptr = 0; // the next interval to feed
        int n = itvs.size();
        
        List<Interval> res = new ArrayList<Interval>();
        
        // if (n == 0) return res;
        
        while (ptr < n) {
            
            if (pq.isEmpty()) {
                pq.add(itvs.get(ptr));
                ++ptr;
            }
            else {
                
                if (pq.peek().end < itvs.get(ptr).start) {
                    
                    res.add(new Interval(pq.peek().end, itvs.get(ptr).start));
                    pq.clear();
                    
                }
                else {
                    
                    pq.add(itvs.get(ptr));
                    ++ptr;
                    
                }
                
            }
            
        } 
        
        return res;
        
        
    }
}