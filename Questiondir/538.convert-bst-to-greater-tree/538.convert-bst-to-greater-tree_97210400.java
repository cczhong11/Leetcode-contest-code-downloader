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
        utilConvert(root, 0);
        return root;
    }
    
    private int utilConvert(TreeNode root, int sum){
        // sum is an offset
        // return sum of nodes still
        if(null == root)
            return 0;
            
        int r = utilConvert(root.right, sum);
        int l = utilConvert(root.left, r + sum + root.val);
        int res = r + l + root.val;
        root.val += r + sum;
        
        return res;
    }
    
}