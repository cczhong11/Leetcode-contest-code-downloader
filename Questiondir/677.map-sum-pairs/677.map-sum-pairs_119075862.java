class MapSum {
    
    class TrieNode{
        TrieNode[] next;
        Integer value;
        public TrieNode(){
            next = new TrieNode[256];
            value = null;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        update(key, val);
    }
    
    private void update(String key, int val) {
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            int c = (int)key.charAt(i);
            if (cur.next[c] == null) {
                cur.next[c] = new TrieNode();
            }
            cur = cur.next[c];
        }
        cur.value = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = (int)prefix.charAt(i);
            if (cur.next[c] == null) {
                return 0;
            }
            cur = cur.next[c];
        }
        return dfs(cur);
    }
    
    private int dfs(TrieNode cur) {
        if (cur == null) {
            return 0;
        }
        
        int sum = 0;
        if (cur.value != null) {
            sum += cur.value;
        }
        
        for (int i = 0; i < 256; i++) {
            sum += dfs(cur.next[i]);
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