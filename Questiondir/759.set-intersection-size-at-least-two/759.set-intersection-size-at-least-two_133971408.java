class Solution {
private static class Interval implements Comparable<Interval> {
		public int start , end;
		public int cnt;
		public Interval(int start , int end) {
			this.start = start;
			this.end = end;
			this.cnt = 0;
		}
		public int compareTo(Interval interval) {
			if (this.end < interval.end) {
				return - 1;
			} else if (this.end > interval.end) {
				return 1;
			} else {
				return 0;
			}
		}
	}
		
    public int intersectionSizeTwo(int[][] intervals) {
        
    	List<Interval> list = new ArrayList<>();
    	int i , n = intervals.length;
    	for (i = 0;i < n;i ++) {
    		list.add(new Interval(intervals[i][0] , intervals[i][1]));
    	}
    	Collections.sort(list);
    	int ans = 0;
    	for (i = 0;i < n;i ++) {
    		Interval interval = list.get(i);
    		if (interval.cnt == 0) {
    			int pos = i + 1;
    			while (pos < n && list.get(pos).start <= interval.end) {
    				list.get(pos).cnt ++;
    				if (list.get(pos).start < interval.end) {
    					list.get(pos).cnt ++;
    				}
    				pos ++;
    			}
    			ans += 2;
    		} else if (interval.cnt == 1) {
    			int pos = i + 1;
    			while (pos < n && list.get(pos).start <= interval.end) {
    				list.get(pos).cnt ++;
    				pos ++;
    			}
    			ans ++;
    		}
    	}
    	return ans;
    	
    }
}