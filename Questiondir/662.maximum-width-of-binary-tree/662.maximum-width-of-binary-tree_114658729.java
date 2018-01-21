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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> binaryQueue = new ArrayDeque<>();
        queue.offer(root);
        binaryQueue.offer(0);
        int maxlen = 0;
        while(!queue.isEmpty()) {
               int n = queue.size();
               int minbinary = 0, maxbinary = 0;
               for(int i = 0; i < n; i++) {
                   TreeNode cur = queue.poll();
                   int curb = binaryQueue.poll();
                   if(i == 0) minbinary = curb;
                   if(i == n-1) maxbinary = curb;
                   if(cur.left != null) {
                       queue.offer(cur.left);
                       binaryQueue.offer(curb << 1);
                   } 
                   if(cur.right != null) {
                       queue.offer(cur.right);
                       binaryQueue.offer((curb << 1) + 1);
                   }
               }
               maxlen = Math.max(maxlen, maxbinary - minbinary + 1);
         }
         return maxlen;
    }
}