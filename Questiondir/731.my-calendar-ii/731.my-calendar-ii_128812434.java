import java.util.ArrayList;

class MyCalendarTwo {
	final static int MAX = 1005;
	static class Event {
		int start;
		int end;
		Event(int _start, int _end) {
			start = _start;
			end = _end;
		}
	}
	ArrayList<Event> calendar;
	ArrayList<Event> common;
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        common = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int i = 0; i < common.size(); ++i) {
        	if (end <= common.get(i).start || start >= common.get(i).end) {
        		continue;
        	}
        	return false;
        }
        for (int i = 0; i < calendar.size(); ++i) {
        	if (end <= calendar.get(i).start || start >= calendar.get(i).end) {
        		continue;
        	}
        	int s = Math.max(start, calendar.get(i).start);
        	int t = Math.min(end, calendar.get(i).end);
        	common.add(new Event(s, t));
        }
        calendar.add(new Event(start, end));
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */