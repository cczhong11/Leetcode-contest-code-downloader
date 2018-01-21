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
    List<Double> ans=new ArrayList<>();
    List<Integer> a=new ArrayList<>();
    void dfs(TreeNode root,int x)
    {
        if (root==null) return;
        if (ans.size()==x)
        {
            ans.add(1.0*root.val);
            a.add(1);
        }
        else 
        {
            ans.set(x,ans.get(x)+1.0*root.val);
            a.set(x,a.get(x)+1);
        }
        dfs(root.left,x+1);
        dfs(root.right,x+1);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        if (root==null) return ans;
        dfs(root,0);
        for (int i=0;i<ans.size();i++) ans.set(i,ans.get(i)/a.get(i));
        return ans;
    }
}