class MyCalendar {
    
    class Interval implements Comparable<Interval> {
        int start, end;
        public Interval(int s, int e) {start = s; end = e;}
        public int compareTo(Interval v) {
            if (start<v.start) return -1;
            else if(start>v.start) return 1;
            else return 0;
        }
        
        public void merge(Interval v) {
            if(start>v.end || end>v.start) throw new RuntimeException("This interval "+this+" cannot be merged with "+v+".");
            if(start>v.start) start = v.start;
            if(end<v.end) end = v.end;
        }
        
        public String toString() {
            return "{"+start+","+end+"}";
        }
    }
    
    TreeSet<Interval> set;

    public MyCalendar() {
        set = new TreeSet<Interval>();
        set.add(new Interval(-3,-2));
        set.add(new Interval(1000000002,1000000003));
    }
    
    public boolean book(int start, int end) {
        Interval interval = set.floor(new Interval(start, start));
        Interval target = new Interval(start, end);
        while(interval.end<=target.start) interval = set.higher(interval);
        if(interval.start<target.end) return false;
        else {
            set.add(target);
            return true;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */