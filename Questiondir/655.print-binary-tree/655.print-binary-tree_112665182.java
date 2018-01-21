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
    
    public List<List<String>> printTree(TreeNode root) {
        int dep = depth(root);
        int len = (1 << dep) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < dep; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < len; j++) {
                res.get(i).add("");
            }
        }

        printSubTree(res, 0, root, 0, len);
        return res;

    }
    
    void printSubTree(List<List<String>> res, int dep, TreeNode root, int l, int r) {
        if (root == null) return;
        
        int pos = (l + r) / 2;
        res.get(dep).set(pos, String.valueOf(root.val));

        printSubTree(res, dep + 1, root.left, l, pos - 1);
        printSubTree(res, dep + 1, root.right, pos + 1, r);
    }

    int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}