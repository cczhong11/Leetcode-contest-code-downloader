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
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        path(root, res, map);
        return res;
    }
    
    private String path(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if(root==null) {
            return "#";
        }
        String l = path(root.left, res, map);
        String r = path(root.right, res, map);
        String tmp = Integer.toString(root.val)+","+l+","+r;
        if(map.containsKey(tmp)) {
            if(map.get(tmp)==1) {
                res.add(root);
                map.put(tmp, 2);
            }
        } else {
            map.put(tmp, 1);
        }
        return tmp;
    }
}