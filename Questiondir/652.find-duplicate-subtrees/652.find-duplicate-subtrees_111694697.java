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
        Map<String, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> ret = new ArrayList<>();
        dfs(root, map);
        for (Map.Entry<String, List<TreeNode>> ent : map.entrySet()) {
            List<TreeNode> list = ent.getValue();
            if (list.size() > 1) {
                ret.add(list.get(0));
            }
        }
        return ret;
    }
    private String dfs(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null) {
            return "";
        } 
        String key = root.val + "(" + dfs(root.left, map) + ")(" + dfs(root.right, map) + ")";
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<TreeNode>());
        }
        map.get(key).add(root);
        return key;
    }
}