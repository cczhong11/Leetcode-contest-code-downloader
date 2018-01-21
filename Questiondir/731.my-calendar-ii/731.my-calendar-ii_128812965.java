class MyCalendarTwo {
    List<int[]> li1 = new ArrayList<>();
    List<int[]> li2 = new ArrayList<>();
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        for(int[] c : li2){
            if(c[0]==start || c[1]==end){
                return false;
            }
            if(c[0]<start && start<c[1] || c[0]>start && c[0]<end){
                return false;
            }
        }
        for(int[] c : li1){
            if(c[0]==start || c[1]==end || c[0]<start && start<c[1] || c[0]>start && c[0]<end){
                int a = Math.max(c[0],start);
                int b = Math.min(c[1],end);
                li2.add(new int[]{a,b});
            }
        }
        li1.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */