class MapSum {
    
    HashMap<String, Set<String>> prefix2Strings;
    HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        prefix2Strings = new HashMap<>();
        map = new HashMap<>();
        
    }
    
    public void insert(String key, int val) {
        if(map.containsKey(key)) {
            map.put(key, val);
            return;
        } 
        
        map.put(key, val);
        for(int i = 0; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            if(!prefix2Strings.containsKey(prefix)) {
                prefix2Strings.put(prefix, new HashSet<>());
            }
            prefix2Strings.get(prefix).add(key);
        }
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(String key : prefix2Strings.getOrDefault(prefix, new HashSet<>())) {
            sum += map.get(key);
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