class MapSum {
    
    class Node {
        boolean isActualVal = false;
        Character keyDigit;
        int val;
        int accumulatedVal = 0;
        Map<Character, Node> childNodes = new HashMap<>();
        
        public Node(Character keyDigit, int val) {
            this.keyDigit = keyDigit;
            this.val = val;
            this.accumulatedVal = val;
        }
    }
    
    Node root;
    Map<String, Integer> valMap;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node(null, 0);
        valMap = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int curVal = valMap.containsKey(key) ? valMap.get(key) : 0;
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            cur.accumulatedVal = cur.accumulatedVal - curVal + val;
            if (!cur.childNodes.containsKey(c)) cur.childNodes.put(c, new Node(c, 0));
            cur = cur.childNodes.get(c);
        }
        cur.isActualVal = true;
        cur.val = val;
        cur.accumulatedVal = cur.accumulatedVal - curVal + val;
        valMap.put(key, val);
    }
    
    public int sum(String prefix) {
        Node cur = root;
        int result = 0;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.childNodes.containsKey(c)) return 0;
            cur = cur.childNodes.get(c);
        }
        return cur.accumulatedVal;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */