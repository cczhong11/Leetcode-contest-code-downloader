class MapSum {
    
    // assume all lower case letters
    private class TNode {
        boolean exist = false;
        int val;
        TNode[] next = new TNode[26]; // init to null
    }
    
    private TNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TNode();
    }
    
    public void insert(String key, int val) {
        TNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new TNode();
            }
            cur = cur.next[c - 'a'];
        }
        cur.exist = true;
        cur.val = val;
    }
    
    public int sum(String prefix) {
        TNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next[c - 'a'] == null) {
                return 0; // nothing to sum at all
            }
            cur = cur.next[c - 'a'];
        }
        return sumHelper(cur);
    }
    private int sumHelper(TNode tn) {
        if (tn == null) {
            return 0;
        }
        int localSum = 0;
        if (tn.exist) {
            localSum += tn.val;
        }
        for (int i = 0; i < 26; i++) {
            if (tn.next[i] != null) {
                localSum += sumHelper(tn.next[i]);
            }
        }
        return localSum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */