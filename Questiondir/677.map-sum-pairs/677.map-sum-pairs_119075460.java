class MapSum {

    private TreeMap<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new TreeMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int result = 0;
        for (String key : map.tailMap(prefix).keySet()) {
            if (key.startsWith(prefix)) {
                result += map.get(key);
            } else {
                break;
            }
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */