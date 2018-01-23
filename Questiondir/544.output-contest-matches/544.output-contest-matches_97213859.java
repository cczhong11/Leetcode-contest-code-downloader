public class Solution {
    
    class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
        public TreeNode(){ this(0); }
        public String toString(){
            if(left==null) return Integer.toString(val);
            else return "("+left.toString()+","+right.toString()+")";
        }
    }
    
    public String findContestMatch(int n) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        LinkedList<TreeNode> bag = new LinkedList(), nextbag;
        bag.add(root.left);
        bag.add(root.right);
        
        int m = 2;
        
        while(n>m){
            m *= 2;
            // System.out.println(root);
            nextbag = new LinkedList();
            for(TreeNode node : bag){
                node.left = new TreeNode(node.val);
                node.right = new TreeNode(m+1-node.val);
                nextbag.add(node.left);
                nextbag.add(node.right);
            }
            bag = nextbag;
        }
        return root.toString();
    }
}