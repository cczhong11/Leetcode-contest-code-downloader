class RangeModule {
class Range implements Comparable<Range> {
        int left;
        int right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Range o) {
            if (this.left != o.left) return this.left - o.left;
            else return this.right - o.right;
        }

        public void merge(Range o) {
            this.left = Math.min(this.left, o.left);
            this.right = Math.max(this.right, o.right);
        }
    }

    TreeSet<Range> treeSet = new TreeSet<>();

    public RangeModule() {
        
    }
    
    public void addRange(int left, int right) {
        Range newRange = new Range(left, right);
        while (true) {
            Range floor = treeSet.floor(newRange);
            if (floor == null || floor.right < newRange.left) break;
            treeSet.remove(floor);
            newRange.merge(floor);
        }
        while (true) {
            Range ceil = treeSet.ceiling(newRange);
            if (ceil == null || ceil.left > newRange.right) break;
            treeSet.remove(ceil);
            newRange.merge(ceil);
        }
        treeSet.add(newRange);
    }
    
    public boolean queryRange(int left, int right) {
        Range query = new Range(left, right);
        Range floor = treeSet.floor(query);
        Range ceil = treeSet.ceiling(query);
        return (floor != null && floor.left <= query.left && floor.right >= query.right)
                || (ceil != null && ceil.left <= query.left && ceil.right >= query.right);
    }
    
    public void removeRange(int left, int right) {
        Range range = new Range(left, right);
        while (true) {
            Range floor = treeSet.floor(range);
            if (floor == null || floor.right <= range.left) break;
            treeSet.remove(floor);
            if (floor.left < range.left) treeSet.add(new Range(floor.left, range.left));
            if (floor.right > range.right) treeSet.add(new Range(range.right, floor.right));
        }
        while (true) {
            Range ceil = treeSet.ceiling(range);
            if (ceil == null || ceil.left >= range.right) break;
            treeSet.remove(ceil);
            if (ceil.right > range.right) treeSet.add(new Range(range.right, ceil.right));
            if (ceil.left < range.left) treeSet.add(new Range(ceil.left, range.left));
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