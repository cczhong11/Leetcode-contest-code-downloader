class MapSum {
    Map<String,Integer> map=new HashMap<>();
    class TrieNode 
    {
        TrieNode[] next=new TrieNode[26];
        int sum;
    }
    TrieNode root=new TrieNode();
    void add(String word,int di) 
    {
        TrieNode p=root;
        p.sum+=di;
        for (char c:word.toCharArray()) 
        {
            if (p.next[c-97]==null) p.next[c-97]=new TrieNode();
            p=p.next[c-97];
            p.sum+=di;
        }
    }
    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        int di=val-map.getOrDefault(key,0);
        map.put(key,val);
        add(key,di);
    }
    
    public int sum(String prefix) {
        TrieNode p=root;
        for (char c:prefix.toCharArray()) 
        {
            if (p.next[c-97]==null) p.next[c-97]=new TrieNode();
            p=p.next[c-97];
        }
        return p.sum;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */