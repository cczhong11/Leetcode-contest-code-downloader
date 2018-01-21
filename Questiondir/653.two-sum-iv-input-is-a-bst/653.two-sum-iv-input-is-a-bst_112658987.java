/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private boolean visit(TreeNode root, int k,HashSet<Integer> vals){
        if(root == null) return false;
        if(vals.contains(k - root.val)) return true;
        vals.add(root.val);
        if(visit(root.left,k,vals)) return true;
        if(visit(root.right,k,vals)) return true;
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        return visit(root,k,new HashSet<>());
    }
}