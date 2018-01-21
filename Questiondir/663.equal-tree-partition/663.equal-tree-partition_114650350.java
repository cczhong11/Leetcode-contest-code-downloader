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
    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return false;
        }
        
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int total = getSum(root, map);
        if (total % 2 != 0) {
            return false;
        }
        
        return traverse(root, map, total/2);
    }
    
    private int getSum(TreeNode node, HashMap<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        
        if(map.containsKey(node)) {
            return map.get(node);
        }
        int left = getSum(node.left, map);
        int right = getSum(node.right, map);
        map.put(node, left + right + node.val);
        return map.get(node);
    }
    
    private boolean traverse(TreeNode node, HashMap<TreeNode, Integer> map, int target) {
        if (node == null) {
            return false;
        }
        if (map.get(node) == target) {
            return true;
        }
        return traverse(node.left, map, target) || traverse(node.right, map, target);
    }
    
    
}