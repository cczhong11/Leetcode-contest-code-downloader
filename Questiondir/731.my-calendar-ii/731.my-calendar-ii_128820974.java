class MyCalendarTwo {
    
    private class Interval implements Comparable<Interval> {
        
        public int start;
        public int end;
        public int count;
        
        public Interval(int s, int e, int c) {
            
            start = s;
            end = e;
            count = c;
            
        }
        
        public int compareTo(Interval i) {
            
            return start - i.start;
            
        }
        
        
    }
    
    
    TreeSet<Interval> set;
    

    public MyCalendarTwo() {
        
        set = new TreeSet<Interval>();
        
    }
    
    public boolean book(int start, int end) {
        
        // find the overlap intervals
        Interval tmp = new Interval(end, end, 1);
        
        List<Interval> list = new LinkedList<Interval>();
        
        while (set.lower(tmp) != null) {
            
            Interval tmp2 = set.lower(tmp);
            if (tmp2.end <= start) break;
            
            // there is an overlap
            list.add(0, tmp2);
            set.remove(tmp2);
            
        }
        
        // check whether there are three overlap
        boolean flag = false;
        for(Interval i: list) {
            
            if (i.count == 2) flag = true;
            
        }
        
        if (flag) {
            
            for(Interval i: list) set.add(i);
            return false;
            
        }
        
        // update the intervals
        int ptr = start;
        
        while (ptr < end && !list.isEmpty()) {
            
            if (list.get(0).start < ptr) {
                
                set.add(new Interval(list.get(0).start, ptr, list.get(0).count));
                list.get(0).start = ptr;
                if (list.get(0).start == list.get(0).end) list.remove(0);
                
            }
            else if (ptr < list.get(0).start) {
                
                set.add(new Interval(ptr, list.get(0).start, 1));
                ptr = list.get(0).start;
                
            }
            else {
                
                int end_tmp = Math.min(end, list.get(0).end);
                set.add(new Interval(ptr, end_tmp, 2));
                ptr = end_tmp;
                list.get(0).start = end_tmp;
                if (list.get(0).start == list.get(0).end) list.remove(0);
                
            }
            
        }
        
        if (ptr < end) set.add(new Interval(ptr, end, 1));
        for (Interval i:list) set.add(i);        
        
        return true;
        
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */