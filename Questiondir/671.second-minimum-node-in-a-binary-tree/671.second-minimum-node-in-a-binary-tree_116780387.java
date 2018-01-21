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
        if (root == null || root.left == null) return -1;
        List<Integer> valList = new ArrayList<>();
        addValue(root, valList);
        Collections.sort(valList);
        int val = valList.get(0);
        for (int v : valList) {
            if (v > val) return v;
        }
        return -1;
    }

    void addValue(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) return;
        list.add(treeNode.val);
        addValue(treeNode.left, list);
        addValue(treeNode.right, list);
    }
}