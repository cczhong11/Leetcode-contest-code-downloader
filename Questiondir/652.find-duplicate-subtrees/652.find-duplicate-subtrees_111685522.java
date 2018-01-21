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
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null)  return result;
        convert(root);
        for(String item: map.keySet()) {
            if(map.get(item) >= 2) {
                
                result.add(deserialize(item));
            }
        }
        return result;
    }
    
    public void convert(TreeNode root) {
        if(root == null)  return;
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        convert(root.left);
        convert(root.right);
    }
    
    public void buildString(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append("N" + ",");
        } else {
            sb.append(root.val + ",");
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }
    
    public TreeNode deserialize(String data) {
        Queue<String> qu = new LinkedList<>();
        qu.addAll(Arrays.asList(data.split(",")));
        return buildTree(qu);
    }
    
    public TreeNode buildTree(Queue<String> qu) {
        if(qu.isEmpty())  return null;
        String cur = qu.remove();
        if(cur.equals("N")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(cur));
            root.left = buildTree(qu);
            root.right = buildTree(qu);
            return root;
        }
    }
}