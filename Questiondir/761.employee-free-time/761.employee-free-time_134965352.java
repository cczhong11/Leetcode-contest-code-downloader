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
        List<List<Integer>> mainPoints = new ArrayList<>();
        for (List<Interval> avail : avails) {
            for(Interval interval : avail) {
                mainPoints.add(Arrays.asList(interval.start, 0));
                mainPoints.add(Arrays.asList(interval.end, 1));
            }
        }
        mainPoints.sort(Comparator.<List<Integer>>comparingInt(list -> list.get(0)).thenComparingInt(list -> list.get(1)));
        int last = -1;
        int used = 0;
        List<Interval> free = new ArrayList<>();
        for (List<Integer> point: mainPoints) {
            if(point.get(1) == 0) {
                ++ used;
            }
            else {
                -- used;
            }
            if(used == 1) {
                if(last > 0) {
                    free.add(new Interval(last, point.get(0)));
                }
                last = -1;
            }
            else if(used == 0) {
                last = point.get(0);
            }
        }
        return free;
    }
}