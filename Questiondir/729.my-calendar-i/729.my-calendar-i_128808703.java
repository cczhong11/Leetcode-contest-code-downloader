class MyCalendar {
	final static int MAX = 1005;
	int N;
	int[][] calendar;
    public MyCalendar() {
    	N = 0;
        calendar = new int[MAX][2];
    }
    
    public boolean book(int start, int end) {
        for (int i = 0; i < N; ++i) {
        	if (end <= calendar[i][0] || start >= calendar[i][1]) {
        		continue;
        	}
        	return false;
        }
        calendar[N][0] = start;
        calendar[N][1] = end;
        ++N;
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */