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
    
    private List<Integer> set = new ArrayList<>();
    
    public boolean checkEqualTree(TreeNode root) {
        
        int temp = help(root);
        set.remove(set.size()-1);
        
        for (int s : set) {
            if (s * 2 == temp)
                return true;
        }
        
        return false;
    }
    
    private int help(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = help(node.left);
        int right = help(node.right);
        
        int ans = node.val + left + right;
        
        set.add(ans);
        
        return ans;
    }
}