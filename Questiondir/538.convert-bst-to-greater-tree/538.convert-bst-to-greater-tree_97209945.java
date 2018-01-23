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
    public void addToList(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        addToList(node.left, list);
        list.add(node);
        addToList(node.right, list);
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        addToList(root, list);
        int len = list.size();
        for (int i = 0; i < len; i++) {
            TreeNode first = list.get(i);
            int val = first.val;
            for (int j = i + 1; j < len; j++) {
                TreeNode second = list.get(j);
                if (second.val > val) {
                    first.val += second.val;
                }
            }
        }
        return root;
    }
}