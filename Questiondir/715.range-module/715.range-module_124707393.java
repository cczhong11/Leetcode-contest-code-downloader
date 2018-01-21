class RangeModule {
    private TreeSet<Pair> treeSet;
    
    public RangeModule() {
        this.treeSet = new TreeSet<Pair>();
    }
    
    public void addRange(int left, int right) {
        Pair p = new Pair(left, right);
        this.treeSet.add(p);
    }
    
    public boolean queryRange(int left, int right) {
        for (Pair p : this.treeSet) {
            if (p.v1 > left) {
                return false;
            }
            if (p.v2 > left) {
                left = p.v2;
                if (left >= right) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        Set<Pair> toAdd = new TreeSet<Pair>();
        Set<Pair> toRem = new TreeSet<Pair>();
        for (Pair p : this.treeSet) {
            if (p.v1 < right && p.v2 > left) {
                if (p.v1 < left) {
                    toAdd.add(new Pair(p.v1, left));
                }
                if (right < p.v2) {
                    toAdd.add(new Pair(right, p.v2));
                }
                toRem.add(p);
            }
            if (p.v1 >= right) {
                break;
            }
        }
        for (Pair p : toRem) {
            this.treeSet.remove(p);
        }
        for (Pair p : toAdd) {
            this.treeSet.add(p);
        }
    }
    
    private class Pair implements Comparable<Pair> {
        public int v1, v2;
        public Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
        
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            
            if (!(o instanceof Pair)) {
                return false;
            }
            
            Pair p = (Pair) o;
            return p.v1 == this.v1 && p.v2 == this.v2;
        }
        
        public int compareTo(Pair p) {
            if (this.v1 != p.v1) {
                return this.v1 - p.v1;
            }
            return this.v2 - p.v2;
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