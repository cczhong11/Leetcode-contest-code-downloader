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
    int rootVal;
    
    public int findSecondMinimumValue(TreeNode root) {
        rootVal=root.val;
        return dfs(root);
    }
    
    int dfs(TreeNode node) {
        if(node.val!=rootVal)
            return node.val;
        if(node.left==null)
            return -1;
        int leftR=dfs(node.left), rightR=dfs(node.right);
        if(leftR==-1&&rightR==-1)
            return -1;
        if(leftR==-1)
            return rightR;
        if(rightR==-1)
            return leftR;
        return Math.min(rightR, leftR);
    }
}