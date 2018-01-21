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
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null)
            return -1;
        
        int minVal = root.val;
        search(root, minVal);
        
        return ans;
    }
    
    private void search(TreeNode cur, int minVal){
        if (cur==null){
            return;
        }
        
        if (cur.val==minVal){
            search(cur.left, minVal);
            search(cur.right, minVal);
        }
        else{
            if (ans==-1 || ans>cur.val)
                ans = cur.val;
        }
    }
}