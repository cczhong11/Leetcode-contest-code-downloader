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
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        if(root == null) return new ArrayList<>();
        int h = getHeight(root);

        int level = 1;
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        List<List<String>> ret = new ArrayList<>();
        while (level <= h){
            List<String> out = new ArrayList<>();
            int padding = (int) (Math.pow(2,h - level) - 1),spacing = (int) (Math.pow(2,h - level + 1) - 1);
            for(int i = 0;i<padding;i++) out.add("");

            int cnt = levels.size();
            for(int i = 0;i<cnt;i++){
                TreeNode node = levels.remove();
                if(node == null){
                    levels.add(null);
                    levels.add(null);
                    out.add("");
                }else{
                    levels.add(node.left);
                    levels.add(node.right);
                    out.add(new Integer(node.val).toString());
                }
                if(i < cnt - 1) for(int j = 0;j<spacing;j++) out.add("");
            }

            for(int i = 0;i<padding;i++) out.add("");
            ret.add(out);
            level++;
        }
        return ret;
    }
}