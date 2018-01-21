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
    HashMap<TreeNode, Integer> map = new HashMap<>();
    int longestPath = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        map = new HashMap<>();
        map.put(null, 0);
        search(root);
        
        if (root==null)
            return 0;
        
        longestPath = 0;
        findLongestPath(root);
        
        return longestPath-1;
    }
    
    private void search(TreeNode cur){
        if (cur==null)
            return;
        search(cur.left);
        search(cur.right);
        
        int res = 1;
        if (cur.left!=null && cur.val==cur.left.val && map.get(cur.left)+1 > res)
            res = map.get(cur.left)+1;
        if (cur.right!=null && cur.val==cur.right.val && map.get(cur.right)+1 > res)
            res = map.get(cur.right)+1;
        map.put(cur, res);
    }
    
    private void findLongestPath(TreeNode cur){
        if (cur==null)
            return;
        int res = 1;
        if (cur.left!=null && cur.val==cur.left.val) res += map.get(cur.left);
        if (cur.right!=null && cur.val==cur.right.val) res += map.get(cur.right);
        longestPath = Math.max(longestPath, res);
        
        findLongestPath(cur.left);
        findLongestPath(cur.right);
    }
}