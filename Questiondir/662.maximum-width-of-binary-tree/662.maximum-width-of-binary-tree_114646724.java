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
        if (root == null)
            return 0;
        
        List<Integer> idx = new ArrayList<>();
        Queue<TreeNode> line = new LinkedList<>();
        idx.add(1);
        line.offer(root);
        
        int res = 1;
        
        while (!line.isEmpty()) {
            res = Math.max(res, idx.get(idx.size()-1) - idx.get(0) + 1);
            
            int size = line.size();
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = line.poll();
                if (node.left != null) {
                    line.offer(node.left);
                    next.add(idx.get(i)*2);
                }
                if (node.right != null) {
                    line.offer(node.right);
                    next.add(idx.get(i)*2+1);
                }
            }
            
            idx = next;
        }
        
        return res;
            
    }
}