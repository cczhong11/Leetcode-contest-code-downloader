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
        
    	List<Interval> list = new ArrayList<>();
    	for (List<Interval> avail : avails) {
    		list.addAll(avail);
    	}
    	Collections.sort(list , (i1 , i2) -> {
    		if (i1.start < i2.start) {
    			return - 1;
    		} else if (i1.start > i2.start) {
    			return 1;
    		} else {
    			return 0;
    		}
    	});
    	int i , n = list.size();
    	List<Interval> ans = new ArrayList<>();
    	int prev = - 1;
    	for (i = 0;i < n;i ++) {
    		int start = list.get(i).start , end = list.get(i).end;
    		while (i < n && list.get(i).start <= end) {
    			if (list.get(i).end > end) {
    				end = list.get(i).end;
    			}
    			i ++;
    		}
    		i --;
    		if (prev < 0) {
    			prev = end;
    		} else {
    			ans.add(new Interval(prev , start));
    			prev = end;
    		}
    	}
    	return ans;
    		
    }
}