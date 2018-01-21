class MapSum {
    
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<String,Integer>();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
        
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */