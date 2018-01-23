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
    public TreeNode convertBST(TreeNode root) {
        return dfs(root, 0);
    }
    
    private TreeNode dfs(TreeNode root, int rightSum) {
        if (root == null) return null;
        
        int rightChild = getSum(root.right);
        dfs(root.right, rightSum);
        root.val += rightChild + rightSum;
        
        dfs(root.left, root.val);
        
        return root;
    }
    
    private int getSum(TreeNode root) {
        if (root == null) return 0;
        
        return root.val + getSum(root.left) + getSum(root.right);
    }
}