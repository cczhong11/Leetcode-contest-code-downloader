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
        if (root == null) { 
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int max = 1;
        traverse(root.left, map, -1, 1);
        traverse(root.right, map,1, 1);
        for (int k : map.keySet()) {
            ArrayList<Integer> curr = map.get(k);
            if (curr.size() < 2) {
                continue;
            }
            int minCurr = curr.get(0), maxCurr = curr.get(curr.size() - 1);
            int can = 0;
            if (maxCurr * minCurr < 0) {
                can = maxCurr - minCurr;
            } else {
                can = maxCurr - minCurr + 1;
            }
            max = Math.max(max, can);
        }
        
        return max;
    }
    
    private void traverse(TreeNode cur, HashMap<Integer, ArrayList<Integer>> map,int pos, int level) {
        if (cur == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(pos);
        traverse(cur.left, map, pos < 0 ? pos * 2 : pos * 2 - 1, level + 1);
        traverse(cur.right, map, pos < 0 ? pos * 2 + 1 : pos * 2, level + 1);
    }
    
}