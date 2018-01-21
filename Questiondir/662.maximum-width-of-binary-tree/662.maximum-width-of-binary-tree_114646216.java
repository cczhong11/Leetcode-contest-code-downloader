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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> q11 = new ArrayDeque<>();
        ArrayDeque<Integer> q21 = new ArrayDeque<>();
        
        int res = 0;
        
        q11.offer(root);
        q21.offer(0);
        
        while (!q11.isEmpty()) {
            res = Math.max(res, q21.peekLast() - q21.peekFirst() + 1);
            ArrayDeque<TreeNode> q12 = new ArrayDeque<>();
            ArrayDeque<Integer> q22 = new ArrayDeque<>();
            
            while (!q11.isEmpty()) {
                TreeNode node = q11.poll();
                int pos = q21.poll();
                if (node.left != null) {
                    q12.offer(node.left);
                    q22.offer(pos * 2);
                }
                
                if (node.right != null) {
                    q12.offer(node.right);
                    q22.offer(pos * 2 + 1);
                }
            }
            
            q11 = q12;
            q21 = q22;
        }
        
        return res;
    }
}