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
        PriorityQueue<End> pq = new PriorityQueue<>();
        for(List<Interval> avail: avails){
            for(Interval it: avail){
                pq.add(new End(it.start, 1));
                pq.add(new End(it.end, -1));
            }
        }
        
        List<Interval> res = new ArrayList<>();
        End e = pq.poll();
        int index = -1;
        int cnt = e.num;
        while(pq.size() > 0){
            e = pq.poll();
            if(cnt == 0 && index != -1){
                res.add(new Interval(index, e.index));
                index = -1;
            }
            cnt += e.num;
            if( cnt == 0 && pq.size() > 0 && pq.peek().index != e.index){
                index = e.index;
            }
        }
        return res;
    }
}
class End implements Comparable<End>{
    int index;
    int num;
    public End(int index, int num){
        this.index = index;
        this.num = num;
    }
    public int compareTo(End e){
        return this.index - e.index;
    }
}