class MyCalendar {
    List<int[]> li = new ArrayList<>();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        for(int[] c : li){
            if(c[0]==start || c[1] == end){
                return false;
            }
            if(c[0]<start && c[1]>start || c[0]>start && c[0] < end ){
                return false;
            }
        }
        li.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */