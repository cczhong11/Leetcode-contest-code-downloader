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
    HashMap<Integer, Integer> map = new HashMap<>();
    public boolean checkEqualTree(TreeNode root) {
        int sum = getSum(root);
        if (sum % 2!=0)
            return false;
        
        return (map.containsKey(sum/2) && (map.get(sum/2)>1 || sum!=0));
    }
    
    private int getSum(TreeNode cur){
        if (cur==null)
            return 0;
        
        int leftSum = getSum(cur.left);
        int rightSum = getSum(cur.right);
        int sum = leftSum + rightSum + cur.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}