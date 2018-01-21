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
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set);
        if (set.size() <= 1) {
        	return -1;
        } else {
        	Iterator<Integer> it = set.iterator();
        	it.next();
        	return it.next();
        }
    }
    
    private void dfs(TreeNode root, TreeSet<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
        
    }
}