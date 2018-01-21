class RangeModule {
    class Interval {
        int start;
        int end;
    }
    TreeMap<Integer, Integer> maps = new TreeMap();
    public RangeModule() {
        
    }
    
    public void addRange(int left, int right) {
        while (maps.ceilingKey(left) != null) {
            int nextKey = maps.ceilingKey(left);
            if (nextKey > right) {
                break;
            } else {
                right = Math.max(right, maps.remove(nextKey));
            }
        }
        while (maps.floorKey(left) != null) {
            int preKey = maps.floorKey(left);
            if (maps.get(preKey) < left) {
                break;
            } else {
                right = Math.max(right, maps.remove(preKey));
                left = preKey;
            }
        }
        maps.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        
        Integer preKey = maps.floorKey(left);
        // if (left == 2) {
        //     System.out.println(preKey);
        //     System.out.println( maps.get(preKey));
        //     System.out.println( maps.get(8));
        // }
        return preKey != null && maps.get(preKey) >= right;        
    }
    
    public void removeRange(int left, int right) {
        while (maps.ceilingKey(left) != null) {
            int nextKey = maps.ceilingKey(left);
            if (nextKey >= right) {
                break;
            } else {                
                if (right <= maps.get(nextKey)) {
                    maps.put(right, maps.get(nextKey));
                }
                maps.remove(nextKey);
            }
        }
        while (maps.floorKey(left) != null) {
            int preKey = maps.floorKey(left);
            if (maps.get(preKey) <= left) {
                break;
            } else {
                if (maps.get(preKey) > right) {                    
                    maps.put(right, maps.get(preKey));
                }
                maps.put(preKey, left);            
            }
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