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
        HashSet<Integer> set = new HashSet<>();
        help(root, set);
        List<Integer> lst = new ArrayList(set);
        Collections.sort(lst);
        if (lst.size() < 2) {
            return -1;
        } else {
            return lst.get(1);
        }
    }
    
    private void help(TreeNode node, HashSet<Integer> set) {
        if (node == null) {
            return;
        }
        
        set.add(node.val);
        help(node.left, set);
        help(node.right, set);
    }
}