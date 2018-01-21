class MapSum {
    
    HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int res = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            if (entry.getKey().indexOf(prefix) == 0)
                res += entry.getValue();
        }
        
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */