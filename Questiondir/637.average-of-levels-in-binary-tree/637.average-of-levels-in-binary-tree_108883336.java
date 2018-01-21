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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ls = new ArrayList<>();
        Set<TreeNode> a = new HashSet<>();
        a.add(root);
        while (!a.isEmpty()){
            Set<TreeNode> b = new HashSet<>();
            double sum = 0;
            for (TreeNode n : a) {
                sum += n.val;
                if (n.left != null)
                    b.add(n.left);
                if (n.right != null)
                    b.add(n.right);
            }
            ls.add(sum / a.size());
            a = b;
        }
        return ls;
    }
}