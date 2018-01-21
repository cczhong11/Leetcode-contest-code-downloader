class Solution {
    class Node{
        Map<Character,Node> child;
        String s;
        public Node(){
            this.child=new HashMap<Character,Node>();
            this.s=null;
        }
    }
    public void buildTrie(Node root,String s){
        Node curr=root;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!curr.child.containsKey(ch)){
                curr.child.put(ch,new Node());
            }
            curr=curr.child.get(ch);
        }
        curr.s=s;
    }
    public void search(Node curr,String[] res){
        for(char ch:curr.child.keySet()){
            Node c=curr.child.get(ch);
            if(c.s!=null){
                if(res[0].length()<c.s.length()||(c.s.length()==res[0].length())&&c.s.compareTo(res[0])<0){
                    res[0]=c.s;
                }
                search(c,res);
            }
        }
    }
    public String longestWord(String[] words) {
        Node root=new Node();
        for(int i=0;i<words.length;i++){
            buildTrie(root,words[i]);
        }
        String[] res={""};
        search(root,res);
        return res[0];
    }
}