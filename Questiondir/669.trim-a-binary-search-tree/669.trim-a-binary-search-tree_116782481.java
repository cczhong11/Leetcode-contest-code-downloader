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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root==null)
            return null;
        
        if (inRange(root, L, R)){
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
        else{
            if (root.val < L){
                return trimBST(root.right, L, R);
            }
            else
                return trimBST(root.left, L, R);
        }
    }
    
    private boolean inRange(TreeNode cur, int L, int R){
        if (cur.val<L || cur.val>R)
            return false;
        return true;
    }
}