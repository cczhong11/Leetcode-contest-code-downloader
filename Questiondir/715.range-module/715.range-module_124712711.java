class RangeModule {
    class Range {
        int left, right;
        Range(int l, int r) {
            left = l;
            right = r;
        }
        boolean mix(Range b) {
            if(right < b.left) return false;
            if(left > b.right) return false;
            return true;
        }
    }
    
    private LinkedList<Range> ranges;
    public RangeModule() {
        ranges = new LinkedList<Range>();
    }
    
    public void addRange(int left, int right) {
        Range newrange = new Range(left, right);
        LinkedList<Range> newranges = new LinkedList<Range>();
        for(Range range: ranges) {
            if(range.mix(newrange)){
                if(newrange.left > range.left) newrange.left = range.left;
                if(newrange.right < range.right) newrange.right = range.right;
            }else {
                newranges.add(range);
            }
        }
        newranges.add(newrange);
        ranges = newranges;
    }
    
    public boolean queryRange(int left, int right) {
        // System.out.println("---:" + left + " " + right);
        for(Range range: ranges) {
            // System.out.println(range.left + " " + range.right);
            if(range.left <= left && right <= range.right) return true;
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        Range newrange = new Range(left, right);
        LinkedList<Range> newranges = new LinkedList<Range>();
        for(Range range: ranges) {
            if(range.mix(newrange)){
                if(range.left < newrange.left) {
                    newranges.add(new Range(range.left, newrange.left));
                }
                if(newrange.right < range.right) {
                    newranges.add(new Range(newrange.right, range.right));
                }
            }else {
                newranges.add(range);
            }
        }
        ranges = newranges;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */