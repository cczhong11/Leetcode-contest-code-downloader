class MyCalendarTwo {
    public TreeMap<Integer, Integer> nv=new TreeMap<Integer, Integer>();
    public Set<Interval> ins=new HashSet<Interval>();
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        //check hit
        Set<Interval> hitset=new HashSet<Interval>();
        for (Interval i:ins)
        {
            if ((i.start<end)&&(i.end>start))
            {
                if (i.hits==1)
                    return false;
                else
                    hitset.add(i);
            }
        }
        ins.add(new Interval(start,end,0));
        for (Interval i:hitset)
        {
            int hitarea_start=Math.max(i.start,start);
            int hitarea_end=Math.min(i.end,end);
            ins.add(new Interval(hitarea_start,hitarea_end,1));
        }
        return true;
    }
    private class Interval{
        public int start;
        public int end;
        public int hits;
        public Interval(int s, int e, int h)
        {
            start=s;
            end=e;
            hits=h;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */