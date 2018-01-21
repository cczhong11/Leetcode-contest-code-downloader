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
        List<Integer> res = new ArrayList<>()
            ;
        toList(res, root);
        Collections.sort(res);
        int low = 0, high = res.size() - 1;
        while (low < high) {
            if (res.get(low) + res.get(high) == k) return true;
            if (res.get(low) + res.get(high) < k) low++;
            else high--;
        }
        return false;
        
    }
    void toList(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        toList(list, root.left);
        toList(list, root.right);
    }
}