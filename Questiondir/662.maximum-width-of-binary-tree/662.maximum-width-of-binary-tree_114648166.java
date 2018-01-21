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
    class QNode {
        public TreeNode node;
        public int index;

        public QNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<QNode> q = new ArrayDeque<>();
        q.offer(new QNode(root, 1));
        int ans = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            int maxv = Integer.MIN_VALUE;
            int minv = Integer.MAX_VALUE;
            for (int i = 0; i < sz; i++) {
                QNode curr = q.poll();
                //System.out.println(curr.node.val + ":" + curr.index);
                maxv = Math.max(maxv, curr.index);
                minv = Math.min(minv, curr.index);
                if (curr.node.left != null) {
                    q.offer(new QNode(curr.node.left, curr.index * 2 - 1));
                }
                if (curr.node.right != null) {
                    q.offer(new QNode(curr.node.right, curr.index * 2));
                }
            }
            ans = Math.max(ans, maxv - minv + 1);
        }
        return ans;
    }
}