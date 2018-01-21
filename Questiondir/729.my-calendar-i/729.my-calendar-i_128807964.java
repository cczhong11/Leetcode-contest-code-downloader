	class MyCalendar {
		List<int[]> rs;

	    public MyCalendar() {
	        rs = new ArrayList<>();
	    }
	    
	    public boolean book(int start, int end) {
	        for(int[] r : rs){
	        	if(Math.max(start, r[0]) < Math.min(end, r[1])){
	        		return false;
	        	}
	        }
	        rs.add(new int[]{start, end});
	        return true;
	    }
	}
