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
        
        if(d <= 0) return root;
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=0; i<d-2; i++) {
            int size = queue.size();
            for(int j=0; j<size; j++) {
                TreeNode node = queue.poll();
                if(node != null) {
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }

        if(queue.isEmpty()) return root;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                TreeNode left = new TreeNode(v);
                TreeNode right = new TreeNode(v);
                if(node.left != null) {
                    left.left = node.left;
                }
                if(node.right !=null) {
                    right.right = node.right;
                }
                node.left = left;
                node.right = right;
            }
        }
        
        return root;
    }
}