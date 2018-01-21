class RangeModule {
    List<int[]> ranges;
    
    public RangeModule() {
        this.ranges = new ArrayList<>();
    }
    
    public void addRange(int left, int right) {
        int[] newRange = {left, right};
        
        Iterator<int[]> it = this.ranges.iterator();
        while (it.hasNext()) {
            int[] range = it.next();
            
            if (newRange[1] >= range[0] && range[1] >= newRange[0]) {
                newRange[0] = Math.min(newRange[0], range[0]);
                newRange[1] = Math.max(newRange[1], range[1]);
                
                it.remove();
            }
        }
        
        insertRange(newRange);
    }
    
    public boolean queryRange(int left, int right) {
        for (int i = 0; i < this.ranges.size(); i++) {
            int[] range = this.ranges.get(i);
            
            if (range[0] <= left && right <= range[1]) {
                return true;
            }
        }
        
        return false;
    }
    
    public void removeRange(int left, int right) {
        Iterator<int[]> it = this.ranges.iterator();
        int[] newRange = null;
        
        while (it.hasNext()) {
            int[] range = it.next();
            
            if (left <= range[0] && range[1] <= right) {
                it.remove();
            } else if (range[0] <= left && right <= range[1]) {
                newRange = new int[] {right, range[1]};
                
                range[1] = left;
            } else if (range[0] <= right && right <= range[1]) {
                range[0] = right;
            } else if (range[0] <= left && left <= range[1]) {
                range[1] = left;
            }
        }
        
        if (newRange != null) {
            insertRange(newRange);
        }
    }
    
    private void insertRange(int[] range) {
        if (this.ranges.isEmpty()) {
            this.ranges.add(range);
        } else {
            for (int i = 0; i < this.ranges.size(); i++) {
                if (range[1] <= this.ranges.get(i)[0]) {
                    this.ranges.add(i, range);

                    return;
                }
            }
            
            this.ranges.add(range);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */