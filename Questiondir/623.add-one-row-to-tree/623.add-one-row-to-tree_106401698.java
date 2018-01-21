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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null || d < 0) {
            return null;
        } else if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int size, level = 1;
        TreeNode curr,node;
        
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if (level == d - 1) {
                    node = new TreeNode(v);
                    node.left = curr.left;
                    curr.left = node;
                    node = new TreeNode(v);
                    node.right = curr.right;
                    curr.right = node;
                } else {
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            }
            level++;
        }
        
        return root;
    }
}