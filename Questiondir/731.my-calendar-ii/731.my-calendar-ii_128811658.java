	class MyCalendarTwo {
		List<int[]> es;

	    public MyCalendarTwo() {
	        es = new ArrayList<>();
	    }
	    
	    public boolean book(int start, int end) {
	    	Collections.sort(es, (x, y) -> {
	    		if(x[0] != y[0])return x[0] - y[0];
	    		return x[1] - y[1];
	    	});
	    	int h = 0;
	    	int pre = -1;
	    	for(int[] e : es){
	    		if(h >= 2 && Math.max(pre, start) < Math.min(e[0], end))return false;
    			h += e[1];
    			pre = e[0];
	    	}
	        es.add(new int[]{start, 1});
	        es.add(new int[]{end, -1});
	        return true;
	    }
	}
