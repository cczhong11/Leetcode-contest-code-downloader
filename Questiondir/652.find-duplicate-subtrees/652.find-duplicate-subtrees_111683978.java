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
    private Map<String, List<TreeNode>> groups;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        groups = new HashMap<>();
        toString(root);
        List<TreeNode> result = new ArrayList<>();
        for (List<TreeNode> group : groups.values()) {
            if (group.size() > 1) result.add(group.get(0));
        }
        return result;
    }
    
    private String toString(TreeNode node) {
        if (node == null) return "";
        String result = node.val + "(" + toString(node.left) + ")(" + toString(node.right) + ")";
        groups.putIfAbsent(result, new ArrayList<>());
        groups.get(result).add(node);
        return result;
    }
    
    
}