public class MyCalendarTwo {

	private List<int[]> list = new ArrayList<>();
	
	public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
    	MyCalendar c = new MyCalendar();
    	for (int[] i : list) {
    		if (i[0] < start && i[1] > start) {
    			if (!c.book(start, i[1])) {
    				return false;
    			}
    		} else if (i[0] >= start && i[0] < end) {
    			if (!c.book(i[0], Math.min(i[1], end))) {
    				return false;
    			}
    		}
    	}
    	list.add(new int[] {start, end});
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyCalendarTwo c = new MyCalendarTwo();

		System.out.println(c.book(10, 20));
		System.out.println(c.book(50, 60));
		System.out.println(c.book(10, 40));
		System.out.println(c.book(5, 15));
		System.out.println(c.book(25, 55));
	}

	
	private class MyCalendar {

		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
	    public MyCalendar() {
	        
	    }
	    
	    public boolean book(int start, int end) {
	        Integer i = tm.lowerKey(end);
	        if (i != null && i >= start) {
	        	return false;
	        }
	        i = tm.lowerKey(start);
	        if (i != null && tm.get(i) > start) {
	        	return false;
	        }
	        tm.put(start, end);
	        return true;
	    }
	}
}
