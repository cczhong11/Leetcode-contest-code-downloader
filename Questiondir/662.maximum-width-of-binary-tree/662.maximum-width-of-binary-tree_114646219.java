/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        int max=1;
        List<Integer> location=new ArrayList<>();
        List<TreeNode> nodes=new ArrayList<>();
        location.add(1);
        nodes.add(root);
        
        while (nodes.size()!=0){
            List<Integer> nextlocation=new ArrayList<>();
            List<TreeNode> nextnodes=new ArrayList<>();
            for (int i=0; i<nodes.size(); i++){
                int curl=location.get(i);
                TreeNode curn=nodes.get(i);
                if (curn.left!=null){
                    nextlocation.add(curl*2-1);
                    nextnodes.add(curn.left);
                }
                if (curn.right!=null){
                    nextlocation.add(curl*2);
                    nextnodes.add(curn.right);
                }
            }
            if (nextlocation.size()>1){
                int leftmost=nextlocation.get(0);
                int rightmost=nextlocation.get(nextlocation.size()-1);
                max=Math.max(max, rightmost-leftmost+1);
            }
            nodes=nextnodes;
            location=nextlocation;
        }
        return max;
    }
}