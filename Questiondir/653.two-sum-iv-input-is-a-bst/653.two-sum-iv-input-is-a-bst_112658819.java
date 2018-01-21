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
    public boolean findTarget(TreeNode root, int k) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        HashSet<Integer> set = new HashSet<>();
        while (list.size()>0){
            TreeNode cur = list.remove();
            if (cur==null) continue;
            if (set.contains(k-cur.val))
                return true;
            set.add(cur.val);
            
            list.add(cur.left);
            list.add(cur.right);
        }
        
        return false;
    }
}