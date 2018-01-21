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
    class Result {
        int longestPath;
        int longestRootPath;
        
        public Result(int longestPath, int longestRootPath) {
            this.longestPath = longestPath;
            this.longestRootPath = longestRootPath;
        }
    }
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        Result r = helper(root);
        return Math.max(r.longestPath, r.longestRootPath);
    }
    
    public Result helper(TreeNode root) {
        if (root == null) return null;
        int longestPath = 0;
        int longestRootPath = 0;
        for (TreeNode child : new TreeNode[] { root.left, root.right }) {
            if (child != null) {
                Result result = helper(child);
                longestPath = Math.max(longestPath, result.longestPath);
                if (child.val == root.val) {
                    longestPath = Math.max(longestPath, result.longestRootPath + longestRootPath + 1);
                    longestRootPath = Math.max(longestRootPath, result.longestRootPath + 1);
                } else {
                    longestPath = Math.max(longestPath, result.longestRootPath);
                }
            }
        }
        return new Result(longestPath, longestRootPath);
    }
}