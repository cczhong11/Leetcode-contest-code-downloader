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
        
        List<Double> average = new ArrayList<Double>();
        if(root == null) {
            return average;
        }

        List<Double> sums = new ArrayList<Double>();
        List<Integer> sizes = new ArrayList<Integer>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            sizes.add(size);
            
            double sum = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            
            sums.add(sum);
        }
        
        for(int i=0; i<sums.size(); i++) {
            average.add(sums.get(i) / sizes.get(i));
        }
        
        return average;
                
    }
}