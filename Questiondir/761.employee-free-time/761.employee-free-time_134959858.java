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
        List<Interval> res = new ArrayList<>();
		List<Interval> list = new ArrayList<>();
		for (List<Interval> l: avails) {
			for (Interval i: l) {
				list.add(i);
			}
		}
		Collections.sort(list, (a, b) -> a.start == b.start ? b.end - a.end : a.start - b.start);
		int max_end = list.get(0).end;
		for (int i = 1; i < list.size(); i++) {
			if (max_end < list.get(i).start) {
				res.add(new Interval(max_end, list.get(i).start));
			}
			max_end = Math.max(max_end, list.get(i).end);
		}
		return res;
    }
}