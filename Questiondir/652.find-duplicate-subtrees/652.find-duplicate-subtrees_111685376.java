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
        if (root == null) return new ArrayList<TreeNode>();
        Map<Integer, Set<TreeNode>> map = new HashMap<>();
        map.put(1, new HashSet<TreeNode>());
        dfs(root, map);
        List<TreeNode> res = new ArrayList<>();
        for (int a : map.keySet()) {
            Set<TreeNode> set = map.get(a);
            getRes(set, res);
        }
        return res;
    }
    private void getRes(Set<TreeNode> set, List<TreeNode> res) {
        while(set.size() > 1) {
            TreeNode curr = set.iterator().next();
            boolean hasFound = false;
            set.remove(curr);
            Set<TreeNode> temp = new HashSet<>();
            for (TreeNode a : set) {
                if (isSame(a, curr)) {
                    hasFound = true;
                    temp.add(a);
                }
            }
            if (hasFound) res.add(curr);
            for (TreeNode a : temp) set.remove(a);
        }
    }
    private int dfs(TreeNode root, Map<Integer, Set<TreeNode>> map) {
        if (root == null) return 0;
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int res = Math.max(left, right) + 1;
        if (!map.containsKey(res)) map.put(res, new HashSet<TreeNode>());
        map.get(res).add(root);
        return res;
    }
    private boolean isSame(TreeNode A, TreeNode B) {
        if (A == null) return B == null;
        if (B == null) return A == null;
        if (A.val != B.val) return false;
        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}