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
    Map<Integer,Long> max=new HashMap<>();
    Map<Integer,Long> min=new HashMap<>();
    void dfs(int d,long w,TreeNode root)
    {
        if (root==null) return;
        long x=max.getOrDefault(d,Long.MIN_VALUE);
        max.put(d,Math.max(x,w));
        x=min.getOrDefault(d,Long.MAX_VALUE);
        min.put(d,Math.min(x,w));
        dfs(d+1,w*2,root.left);
        dfs(d+1,w*2+1,root.right);
    }
    public int widthOfBinaryTree(TreeNode root) {
        dfs(0,0,root);
        int ans=0;
        for (int x:max.keySet())
        {
            ans=Math.max(ans,(int)(max.get(x)-min.get(x)));
        }
        return ans+1;
    }
}