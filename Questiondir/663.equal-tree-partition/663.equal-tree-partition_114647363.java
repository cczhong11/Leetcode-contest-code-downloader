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
    TreeNode Root;
    Set<Integer> set=new HashSet<>();
    int sum(TreeNode root)
    {
        if (root==null) return 0;
        int ans=root.val+sum(root.left)+sum(root.right);
        if (root!=Root) set.add(ans);
        return ans;
    }
    public boolean checkEqualTree(TreeNode root) {
        Root=root;
        int tot=sum(root);
        if (tot%2!=0) return false;
        return set.contains(tot/2);
    }
}