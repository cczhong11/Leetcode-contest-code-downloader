class TrieNode{
    TrieNode[] sons;
    Set<String> wordSet;
    public TrieNode(){
        sons = new TrieNode[256];
        wordSet = new HashSet<>();
    }
}
public class MapSum {
    
    /** Initialize your data structure here. */
    TrieNode root;
    Map<String, Integer> map = new HashMap<>();
    public MapSum() {
        root = new TrieNode(); 
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        if(key.isEmpty()) return;
        if(map.containsKey(key)) map.put(key,val);
        else{
            map.put(key,val);
            TrieNode current = root;
            for(int i = 0; i < key.length(); i++){
                int chr = (int)key.charAt(i);
                if(current.sons[chr] == null){
                    current.sons[chr] = new TrieNode();
                }
                current.sons[chr].wordSet.add(key);
                current = current.sons[chr];
            }
        }
    }
    
    public int sum(String prefix) {
        int sum = 0;
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            int chr = (int)prefix.charAt(i);
            if(current.sons[chr] == null){
                current.sons[chr] = new TrieNode();
            }
            current = current.sons[chr];            
        }
        for(String word : current.wordSet){
            sum += map.get(word);
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