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
        List<Interval> all = new ArrayList<Interval>();
        for(List<Interval> avail : avails){
            for(Interval inter : avail){
                all.add(inter);
            }
        }
        Collections.sort(all, (s, t) -> {
            if(s.start != t.start){
                return s.start - t.start;
            }
            return s.end - t.end;
        });
        int start = -1;
        int end = start;
        List<Interval> merged = new ArrayList<Interval>();
        for(Interval inter : all){
            if(start == -1){
                start = inter.start;
                end = inter.end;
            }
            else{
                if(inter.start <= end){
                    if(inter.end > end){
                        end = inter.end;
                    }
                }
                else{
                    Interval merge = new Interval(start, end);
                    merged.add(merge);
                    start = inter.start;
                    end = inter.end;
                }
            }
        }
        Interval merge = new Interval(start, end);
        merged.add(merge);
        List<Interval> free = new ArrayList<Interval>();
        for(int i = 1; i < merged.size(); i++){
            Interval f = new Interval(merged.get(i - 1).end, merged.get(i).start);
            free.add(f);
        }
        return free;
    }
}