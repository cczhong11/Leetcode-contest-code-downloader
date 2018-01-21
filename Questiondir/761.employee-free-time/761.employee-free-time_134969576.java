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
        int n = 0;
        for(List<Interval> avail : avails) n += avail.size();
        int maxvalue = 100000001;
        Interval[] intevals = new Interval[n+2];
        intevals[0] = new Interval(-11,-10);
        intevals[n+1] = new Interval(maxvalue + 10, maxvalue + 11);
        int cur = 1;
        for(List<Interval> avail : avails) {
            for (Interval inteval : avail) {
                intevals[cur++] = inteval;
            }
        }
        Arrays.sort(intevals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start<b.start) return -1;
                if (a.start>b.start) return 1;
                return 0;
            }
        });
        LinkedList<Interval> list = new LinkedList<Interval>();
        int left = -12, right = -9;
        for(Interval inteval : intevals) {
            if (inteval.start <= right) {
                right = Math.max(right, inteval.end);
            } else {
                list.add(new Interval(left, right));
                left = inteval.start;
                right = inteval.end;
            }
        }
        list.add(intevals[n+1]);
        // printc(list, "list : ");
        
        LinkedList<Interval> ret = new LinkedList<Interval>();
        left = -120;
        right = -90;
        for(Interval inteval : list) {
            int _left = right, _right = inteval.start;
            // System.out.println(" " + left + " , " + right);
            if (_left >= 0 && _right<maxvalue) {
                ret.add(new Interval(_left, _right));
            }
            left = inteval.start;
            right = inteval.end;
        }
        // printc(ret, "ret : ");
        return ret;
    }
    
    private void printc(List<Interval> list, String info) {
        StringBuffer s = new StringBuffer().append(info).append("{");
        boolean first = true;
        for(Interval interval : list) {
            if(first) first = false;
            else s.append(",");
            s.append("[").append(interval.start).append(",").append(interval.end).append("]");
        }
        s.append("}");
        System.out.println(s);
    }
}