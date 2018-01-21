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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<TreeNode,Integer> sizes = new HashMap<>();
        if (null != root) {
            genSizes(root, sizes);
        }
        
        Set<TreeNode> nodes = new HashSet<>(sizes.keySet());
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode a : sizes.keySet()) {
            if (nodes.contains(a)) {
                for (TreeNode b : sizes.keySet()) {
                    if (a != b && sizes.get(a) == sizes.get(b) && same(a, b)) {
                        set.add(a);
                        nodes.remove(b);
                    }
                }
            }   
        }
        
        return new ArrayList<TreeNode>(set);
    }
    private void genSizes(TreeNode node, Map<TreeNode,Integer> map) {
        int size = 1;
        if (null != node.left) {
            genSizes(node.left, map);
            size += map.get(node.left);
        }
        if (null != node.right) {
            genSizes(node.right, map);
            size += map.get(node.right);
        }
        map.put(node, size);
    }
    private boolean same(TreeNode a, TreeNode b) {
        if (null == a) {
            return null == b;
        } else if (null == b) {
            return false;
        } else {
            return a.val == b.val && same(a.left, b.left) && same(a.right, b.right);
        }
    }
}