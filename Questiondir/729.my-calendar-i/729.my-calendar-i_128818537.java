class MyCalendar {
    
    private class Interval implements Comparable<Interval> {
        
        public int start;
        public int end;
        
        public Interval(int s, int e) {
            
            start = s;
            end = e;
            
        }
        
        public int compareTo(Interval i) {
            
            return start - i.start;
            
        }
        
    }
    
    TreeSet<Interval> set;

    public MyCalendar() {
        
        set = new TreeSet<Interval>();
        
    }
    
    public boolean book(int start, int end) {
        
        Interval tmp1 = new Interval(end, end);
        Interval tmp2 = set.lower(tmp1);
        if (tmp2 != null && tmp2.end > start) return false;
        else set.add(new Interval(start, end));
        
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */