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
    private TreeNode createTree(TreeNode node) {
        TreeNode ret = new TreeNode(0);
        if (node.left != null) {
            ret.left = this.createTree(node.left);
        }
        if (node.right != null) {
            ret.right = this.createTree(node.right);
        }
        return ret;
    }
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rootG = this.createTree(root);
        Deque<TreeNode> stack = new ArrayDeque<>(), stackG = new ArrayDeque<>();
        TreeNode track = root;
        while (track != null) {
            stack.push(track);
            track = track.right;
        }
        track = rootG;
        while (track != null) {
            stackG.push(track);
            track = track.right;
        }
        int sumSoFar = 0;
        while (!stack.isEmpty()) {
            track = stack.pop();
            sumSoFar += track.val;
            track = track.left;
            while (track != null) {
                stack.push(track);
                track = track.right;
            }
            track = stackG.pop();
            track.val = sumSoFar;
            track = track.left;
            while (track != null) {
                stackG.push(track);
                track = track.right;
            }
        }
        return rootG;
    }
}