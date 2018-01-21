class MapSum {
    
    HashMap<String, Integer> map;
    LinkedList<String> list;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
        list = new LinkedList<>();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {  
            int len = prefix.length();
            String str = e.getKey();
            if(str.length() < len) continue;
            if(str.substring(0,len).equals(prefix))
                sum += e.getValue();
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