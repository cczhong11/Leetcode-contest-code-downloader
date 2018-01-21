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
        Set<TreeNode> result = new HashSet<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        dfs(root, map, result);
        return new ArrayList<TreeNode>(result);
    }
    
    public static int dfs(TreeNode root, Map<Integer, List<TreeNode>> map, Set<TreeNode> result) {
        if (root == null) return 0;
        int hashcode = root.val + 257;
        hashcode = 257 * hashcode + dfs(root.left, map, result);
        hashcode = 257 * hashcode + dfs(root.right, map, result);
        if (map.containsKey(hashcode)) {
            for (TreeNode node : map.get(hashcode)) if (areSame(root, node)) { result.add(node); return hashcode; }
        } else {
            map.put(hashcode, new ArrayList<>());
        }
        map.get(hashcode).add(root);
        return hashcode;
    }
    
    public static boolean areSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return areSame(root1.left, root2.left) && areSame(root1.right, root2.right);
    }
}