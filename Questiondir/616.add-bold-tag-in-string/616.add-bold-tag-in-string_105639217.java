public class Solution {
    class Interval {
		public int start;
		public int end;
		public Interval() {
			start = 0;
			end = 0;
		}
		
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public String addBoldTag(String s, String[] dict) {
        if (dict == null || dict.length == 0 || s == null || s.length() == 0) return s;
        int n = s.length();
        List<Interval> intervals = new ArrayList<>();
        for(String word : dict) {
        	int index = s.indexOf(word, 0);
        	while (index != -1) {
        		Interval i = new Interval(index, index + word.length() - 1);
        		intervals.add(i);
        		int posDiff = word.length() - 1;
        		posDiff = posDiff > 0 ? posDiff : 1;
        		index = s.indexOf(word, index + posDiff);
        	}
        }
        List<Interval> merged = merge(intervals);
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (Interval i : merged) {
        	sb.append(s.substring(prev, i.start));
        	sb.append("<b>").append(s.substring(i.start, i.end + 1));
        	sb.append("</b>");
        	prev = i.end + 1;
        }
        if (prev < n) sb.append(s.substring(prev));
        return sb.toString();
    }
	
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) return intervals;
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o1.start, o2.start);
			}
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
        	if (interval.start <= end + 1) {
        		end = Math.max(end, interval.end);
        	}
        	else {
        		res.add(new Interval(start, end));
        		start = interval.start;
        		end = interval.end;
        	}
        }
        res.add(new Interval(start, end));
        return res;
    }
}