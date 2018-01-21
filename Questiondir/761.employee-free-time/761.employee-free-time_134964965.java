import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (List<Interval> list : avails) {
        	for (Interval interval : list) {
        		int start = interval.start * 2;
        		int end = interval.end * 2 + 1;
        		if (!map.containsKey(start)) {
        			map.put(start, 0);
        		}
        		if (!map.containsKey(end)) {
        			map.put(end, 0);
        		}
        		map.put(start, map.get(start) + 1);
        		map.put(end, map.get(end) - 1);
        	}
        }
        int sum = 0;
        boolean begin = false;
        LinkedList<Interval> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	int key = entry.getKey();
        	int val = entry.getValue();
        	if (val == 0) {
        		continue;
        	}
        	sum += val;
        	//System.out.println(key / 2.0 + ", " + val + ", sum = " + sum + ", begin = " + begin);
        	if (sum == 0 && !begin) {
        		begin = true;
        		Interval ele = new Interval();
        		res.add(ele);
        		res.getLast().start = key / 2;
        	} else if (sum > 0 && begin) {
        		begin = false;
        		res.getLast().end = key / 2;
        	}
        }
        res.removeLast();
        return res;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	List<List<Interval>> avails = new LinkedList<>();
    	List<Interval> l1 = new LinkedList<Interval>();
    	l1.add(new Interval(1, 3));
    	l1.add(new Interval(6, 7));
    	List<Interval> l2 = new LinkedList<Interval>();
    	l2.add(new Interval(2, 4));
    	List<Interval> l3 = new LinkedList<Interval>();
    	l3.add(new Interval(2, 5));
    	l3.add(new Interval(9, 12));
    	avails.add(l1);
    	avails.add(l2);
    	avails.add(l3);
    	List<Interval> res = solution.employeeFreeTime(avails);
    	for (Interval i : res) {
    		System.out.println(i.start + " ->-> " + i.end);
    	}
    }
}