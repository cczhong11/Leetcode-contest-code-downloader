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
        List<Double> avg=new ArrayList<Double>();
        if(root==null){
            return avg;
        }
        Queue<TreeNode> qu=new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            double total=0;
            for(int i=0;i<size;i++){
                TreeNode top=qu.poll();
                total=total+top.val;
                if(top.left!=null){
                    qu.offer(top.left);
                }
                if(top.right!=null){
                    qu.offer(top.right);
                }
            }
            avg.add(total/(double)size);
        }
        return avg;
    }
}