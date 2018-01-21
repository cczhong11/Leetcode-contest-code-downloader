import java.util.Map;

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
    Map<Integer, Integer> map;
    
    void rec(TreeNode root) {
        if (root == null) return;
        int x = root.val;
        if (!map.containsKey(x)) {
            map.put(x, 0);
        }
        map.put(x, map.get(x) + 1);
        rec(root.left);
        rec(root.right);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<>();
        rec(root);
        for (int x : map.keySet()) {
        	int y = k - x;
        	if (y != x && map.containsKey(y)) return true;
        	if (y == x && map.get(y) >= 2) return true;
        }
        return false;
    }
}