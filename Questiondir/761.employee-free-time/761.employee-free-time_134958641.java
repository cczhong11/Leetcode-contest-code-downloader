	class Solution {
	    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
	    	int n = 0;
	    	for(List<Interval> li : avails){
	    		n += li.size();
	    	}
	        int[][] xs = new int[n][];
	        int p = 0;
	    	for(List<Interval> li : avails){
	    		for(Interval i : li){
	    			xs[p++] = new int[]{i.start, i.end};
	    		}
	    	}
	    	int[][] or = or(xs);
	    	List<Interval> ret = new ArrayList<>();
	    	for(int i = 0;i + 1 < or.length;i++){
	    		ret.add(new Interval(or[i][1], or[i+1][0]));
	    	}
	    	return ret;
	    }
	    
		public int[][] or(int[][] a)
		{
			int n = a.length;
			Arrays.sort(a, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return a[0] < b[0] ? -1 : 1;
				}
			});
			
			int p = 0;
			for(int i = 0;i < n;i++){
				if(i == 0 || a[p-1][1] < a[i][0]){
					a[p][0] = a[i][0]; a[p][1] = a[i][1]; p++;
				}else{
					a[p-1][1] = Math.max(a[p-1][1], a[i][1]);
				}
			}
			return Arrays.copyOf(a, p);
		}
	}	
