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
        List<TreeNode> ans = new ArrayList<>();
        if(root != null) {
            HashMap<String, List<TreeNode>> map = new HashMap<>();
            check(root, map);
            for(Map.Entry<String, List<TreeNode>> curr: map.entrySet()) {
                if(curr.getValue().size() > 1) ans.add(curr.getValue().get(0));
            }
        }
        return ans;
    }
    private String check(TreeNode root, HashMap<String, List<TreeNode>> map) {
        StringBuilder ans = new StringBuilder("").append(root.val); 
        if(root.left != null) ans.append(',').append(check(root.left, map));
        else ans.append(',').append('#');
        if(root.right != null) ans.append(',').append(check(root.right, map));
        else ans.append(',').append('#');
        String s = ans.toString();
        if(!map.containsKey(s)) map.put(s, new ArrayList<TreeNode>());
        map.get(s).add(root);
        return s;
    }
}