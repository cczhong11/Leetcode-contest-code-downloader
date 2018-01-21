class MapSum {

    TreeMap<String, Integer> map = new TreeMap<>();
    
    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
    
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        
        int s = 0;
        for (Map.Entry<String, Integer> e : map.tailMap(prefix).entrySet()) {
            String k = e.getKey();
            int v = e.getValue();
            if (!k.startsWith(prefix)) break;
            s += v;
        }
        return s;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */