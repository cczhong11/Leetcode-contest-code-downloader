/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, Integer> notop;
    Map<TreeNode, Integer> noleft;
    Map<TreeNode, Integer> noright;
    
    public boolean checkEqualTree(TreeNode root) {
        if (root==null) return false;
        notop=new HashMap<>();
        noleft=new HashMap<>();
        noright=new HashMap<>();
        int totalsum=subtreesum(root);
        leftandright(root, totalsum);
        
        List<TreeNode> curlevel=new ArrayList<>();
        curlevel.add(root);
        while (curlevel.size()!=0){
            List<TreeNode> nextlevel=new ArrayList<>();
            for (TreeNode n : curlevel){
                if (n.left!=null){
                    if (noleft.get(n)==notop.get(n.left)) return true;
                    nextlevel.add(n.left);
                }
                if (n.right!=null){
                    if (noright.get(n)==notop.get(n.right)) return true;
                    nextlevel.add(n.right);
                }
            }
            curlevel=nextlevel;
        }
        return false;
    }
    
    private int subtreesum(TreeNode cur){
        if (cur.left==null && cur.right==null){
            notop.put(cur, cur.val);
            return cur.val;
        }
        int total=cur.val;
        if (cur.left!=null){
            total+=subtreesum(cur.left);
            
        }
        if (cur.right!=null){
            total+=subtreesum(cur.right);
        }
        notop.put(cur, total);
        return total;
    }
    
    private void leftandright(TreeNode cur, int totalsum){
        if (cur.left==null && cur.right==null) return;
        if (cur.left!=null){
            leftandright(cur.left, totalsum);
            noleft.put(cur, totalsum-notop.get(cur.left));
        }
        if (cur.right!=null){
            leftandright(cur.right, totalsum);
            noright.put(cur, totalsum-notop.get(cur.right));
        }
        return;
    }
}