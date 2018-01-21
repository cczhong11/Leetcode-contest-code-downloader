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
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for (List<Interval> lm : avails) {
            for (Interval inv : lm) {
                if (tm.containsKey(inv.start)) {
                    if (tm.get(inv.start) < inv.end)
                        tm.put(inv.start, inv.end);
                } else {
                    tm.put(inv.start, inv.end);
                }
            }
        }
        ArrayList<Interval> l2 = new ArrayList<Interval>();
        while (!tm.isEmpty()) {
            int start = tm.firstKey();
            int end = tm.remove(start);
            while (!tm.isEmpty() && tm.firstKey() <= end) {
                end = Math.max(end, tm.pollFirstEntry().getValue());
            }
            l2.add(new Interval(start, end));
        }
        ArrayList<Interval> ans = new ArrayList<Interval>();
        for (int i = 0; i < l2.size()-1; i++) {
            ans.add(new Interval(l2.get(i).end, l2.get(i+1).start));
        }
        return ans;
    }
}