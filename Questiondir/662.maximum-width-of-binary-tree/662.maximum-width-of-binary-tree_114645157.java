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
    ArrayList<Integer> minD, maxD;
    
    void traverse(TreeNode root, int d, int id) {
        if (root == null) return;
        
        if (minD.size() <= d) {
            minD.add(id);
        } else {
            int min = Math.min(id, minD.get(d));
            minD.set(d, min);
        }
        
        if (maxD.size() <= d) {
            maxD.add(id);
        } else {
            int max = Math.max(id, maxD.get(d));
            maxD.set(d, max);
        }
        
        traverse(root.left, d + 1, id * 2 + 1);
        traverse(root.right, d + 1, id * 2 + 2);
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        minD = new ArrayList<>();
        maxD = new ArrayList<>();
        
        traverse(root, 0, 0);
        int res = 0;
        for (int i = 0; i < minD.size(); ++i) {
            res = Math.max(res, maxD.get(i) - minD.get(i) + 1);
        }
        return res;
    }
}