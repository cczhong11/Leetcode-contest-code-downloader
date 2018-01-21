class MapSum {
    class Node{
        Map<Character,Node> child;
        Integer val;
        public Node(){
            this.child=new HashMap<Character,Node>();
            this.val=null;
        }
    }
    /** Initialize your data structure here. */
    Node root;
    public MapSum() {
        this.root=new Node();
    }
    
    public void insert(String key, int val) {
        Node curr=this.root;
        for(int i=0;i<key.length();i++){
            char ch=key.charAt(i);
            if(!curr.child.containsKey(ch)){
                curr.child.put(ch,new Node());
            }
            curr=curr.child.get(ch);
        }
        curr.val=val;
    }
    
    public int sum(String prefix) {
        Node curr=this.root;
        int[] res={0};
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(!curr.child.containsKey(ch)){
                return 0;
            }
            curr=curr.child.get(ch);
        }
        getSum(curr,res);
        return res[0];
    }
    public void getSum(Node curr,int[] res){
        if(curr==null){
            return;
        }
        if(curr.val!=null){
            res[0]=res[0]+curr.val;
        }
        for(char key:curr.child.keySet()){
            getSum(curr.child.get(key),res);
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */