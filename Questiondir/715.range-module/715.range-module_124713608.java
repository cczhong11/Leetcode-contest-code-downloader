class RangeModule {
    
    class Range implements Comparable<Range> {
        int left, right;
        public Range(int l, int r) {left = l; right = r;}
        
        public int compareTo(Range r) {
            if(left<r.left) return -1;
            else if(left>r.left) return 1;
            else return 0;
        }
        
        public String toString() {
            return "[" + left + "," + right + ")";
        }
    }
    
    TreeSet<Range> ranges;

    public RangeModule() {
        ranges = new TreeSet();
    }
    
    public void addRange(int left, int right) {
        Range target = new Range(left, right);
        for(Range below = ranges.floor(target); below != null && below.right >= target.left; below = ranges.lower(below)) {
            ranges.remove(below);
            target.left = below.left;
            if(below.right>target.right) target.right = below.right;
        }
        for(Range above = ranges.ceiling(target); above != null && above.left <= target.right; above = ranges.higher(above)) {
            ranges.remove(above);
            if(above.right>target.right) target.right = above.right;
        }
        ranges.add(target);
        // System.out.println("After adding range " + target + " what is left is :");
        // for(Range r : ranges) System.out.print("   " + r);
        // System.out.println();
    }
    
    public boolean queryRange(int left, int right) {
        boolean ret = queryRangeDebugger(left, right);
        // System.out.println("query " + new Range(left, right) + " " + (ret?"true":"false"));
        return ret;
    }
    
    public boolean queryRangeDebugger(int left, int right) {
        Range target = new Range(left, right);
        Range query = ranges.floor(target);
        if(query==null || query.right<target.right) return false;
        else return true;
    }
    
    public void removeRange(int left, int right) {
        Range target = new Range(left, right);
        Range inside = ranges.floor(new Range(right, right));
        while(true) {
            if(inside == null) break;
            Range lower = ranges.lower(inside);
            if(lower == null || lower.right < target.left) break;
            inside = lower;
        }
        for(; inside != null && inside.left < target.right; inside = ranges.higher(inside)) {
            ranges.remove(inside);
            if(inside.left<target.left) { // say target is [10, 20)
                
                if(inside.right<=target.left) { // say inside is [5,10)
                    Range replace = new Range(inside.left, inside.right); // add in [5, 10)
                    ranges.add(replace);
                } else if(inside.right<=target.right) { // say inside is [5,20)
                    Range replace = new Range(inside.left, target.left); // add in [5, 10)
                    ranges.add(replace);
                } else { // say inside is [5, 21)
                    Range replace = new Range(inside.left, target.left); // add in [5, 10)
                    ranges.add(replace);
                    replace = new Range(target.right, inside.right); // add in [20, 21)
                    ranges.add(replace);
                }
            } else {
                if(inside.right>target.right) { // say target is [10, 20), inside is [10, 21)
                    Range replace = new Range(target.right, inside.right); // add in [20, 21)
                    ranges.add(replace);
                }
            }
        }
        // System.out.println("After remove range " + target + " what is left is :");
        // for(Range r : ranges) System.out.print("   " + r);
        // System.out.println();
    }
}

/*

["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange"]
[[],[10,20],[14,16],[10,14],[13,15],[16,17]]
["RangeModule","removeRange","addRange","queryRange","addRange","removeRange","queryRange","queryRange","addRange","removeRange"]
[[],[4,8],[1,10],[1,7],[2,3],[2,3],[8,9],[6,9],[2,3],[1,8]]
["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange","removeRange","removeRange","removeRange","addRange","addRange","addRange","removeRange","addRange","queryRange","addRange","addRange","queryRange","queryRange","addRange","removeRange","removeRange","removeRange","queryRange","queryRange","addRange","addRange","queryRange","addRange","addRange","removeRange","addRange","addRange","queryRange","removeRange","queryRange","removeRange","addRange","addRange","queryRange","removeRange","removeRange","addRange","queryRange","queryRange","removeRange","removeRange","removeRange","queryRange","addRange","removeRange","removeRange","queryRange","removeRange","removeRange","queryRange","addRange","addRange","removeRange","queryRange","queryRange","addRange","removeRange","removeRange","addRange","addRange","addRange","addRange","queryRange","removeRange","addRange","addRange","addRange","queryRange","addRange","removeRange","queryRange","removeRange","removeRange","removeRange","queryRange","queryRange","queryRange","queryRange","queryRange","removeRange","queryRange","removeRange","queryRange","addRange","queryRange"]
[[],[14,100],[1,8],[77,80],[8,43],[4,13],[3,9],[45,49],[41,90],[58,79],[4,83],[34,39],[84,100],[8,9],[32,56],[35,46],[9,100],[85,99],[23,33],[10,31],[15,45],[52,70],[26,42],[30,70],[60,69],[10,94],[2,89],[26,39],[46,93],[30,83],[42,48],[47,74],[39,45],[14,64],[3,97],[16,34],[28,100],[19,37],[27,91],[55,62],[64,65],[2,48],[55,78],[21,89],[31,76],[13,32],[2,84],[21,88],[12,31],[89,97],[56,72],[16,75],[18,90],[46,60],[20,62],[28,77],[5,78],[58,61],[38,70],[24,73],[72,96],[5,24],[43,49],[2,20],[4,69],[18,98],[26,42],[14,18],[46,58],[16,90],[32,47],[19,36],[26,78],[7,58],[42,54],[42,83],[3,83],[54,82],[71,91],[22,37],[38,94],[20,44],[37,89],[15,54],[1,64],[63,65],[55,58],[23,44],[25,87],[38,85],[27,71]]

*/

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */