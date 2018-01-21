class MyCalendar {

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
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	MyCalendar c = new MyCalendar();

		System.out.println(c.book(0, 2));
		System.out.println(c.book(2, 4));
		System.out.println(c.book(3, 5));

	}
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */