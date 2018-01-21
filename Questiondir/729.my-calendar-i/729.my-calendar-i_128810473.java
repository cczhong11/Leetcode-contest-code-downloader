class MyCalendar {
    public TreeMap<Integer, Integer> nv=new TreeMap<Integer, Integer>();
    public Set<Interval> ins=new HashSet<Interval>();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        //check hit
        for (Interval i:ins)
        {
            if ((i.start<end)&&(i.end>start))
            {
                return false;
            }
        }
        ins.add(new Interval(start,end));
        return true;
    }
    private class Interval{
        public int start;
        public int end;
        public Interval(int s, int e)
        {
            start=s;
            end=e;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */