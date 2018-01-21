class MyCalendarTwo {
    
    public static int _count;
    
    

    class Interval implements Comparable<Interval> {
        int start, end;
        Integer count;
        public Interval(int s, int e) {
            start = s; end = e;
            count = new Integer(_count);
            _count += 1;
        }
        public int compareTo(Interval v) {
            if (start<v.start) return -1;
            else if(start>v.start) return 1;
            else return count.compareTo(v.count);
        }
        
        public void merge(Interval v) {
            if(start>v.end || end>v.start) throw new RuntimeException("This interval "+this+" cannot be merged with "+v+".");
            if(start>v.start) start = v.start;
            if(end<v.end) end = v.end;
        }
        
        public String toString() {
            return "{"+start+","+end+"}";
        }
        
        public boolean intersect(Interval v) {
            return (start<v.end && v.start<end);
        }
    }
    
    TreeSet<Interval> set;

    public MyCalendarTwo() {
        _count = 0;
        set = new TreeSet<Interval>();
        set.add(new Interval(-3,-2));
        set.add(new Interval(1000000002,1000000003));
    }
    
    public void println(Object o) {
        // System.out.println(o);
    }
    
    public boolean book(int start, int end) {
        try {
            return book1(start, end);
        } catch (Exception e) {
            println(e);
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean book1(int start, int end) {
        int count = 0;
        Interval target = new Interval(start, end);
        TreeSet<Interval> conflictSet = new TreeSet<Interval>();
        for (Interval interval : set) {
            if (interval.intersect(target)) {
                conflictSet.add(interval);
                println("The target " + target + " conflicts with " + interval);
            }
        }
        boolean canAdd = true;
        try {
            Interval cur = conflictSet.first(); 
            Interval next = conflictSet.higher(cur);
            while(next!=null) {
                if (cur.end > next.start) {
                    canAdd = false;
                    println("Cannot add " + target + ": triple booking with " + cur + " and " + next);
                    break;
                }
                cur = next;
                next = conflictSet.higher(cur);
            }
        } catch (java.util.NoSuchElementException e) {}
        if(!canAdd) {
            println("Cannot book "+target+" count="+count);
            return false;
        }
        else {
            set.add(target);
            return true;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */