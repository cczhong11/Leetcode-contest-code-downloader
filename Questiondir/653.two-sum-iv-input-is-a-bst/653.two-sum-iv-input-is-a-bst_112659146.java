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
    List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        recur(root);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int s = list.get(l) + list.get(r);
            if (s == k) return true;
            if (s > k) --r;
            else ++l;
        }
        return false;
    }
    void recur(TreeNode root) {
        if (root == null) return;
        recur(root.left);
        list.add(root.val);
        recur(root.right);
    }
}