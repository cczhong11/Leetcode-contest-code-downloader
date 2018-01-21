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
    int min1=-1,min2=-1;
    void dfs(TreeNode root)
    {
        if (root==null) return;
        if (min1==-1 || root.val<min1)
        {
            if (min1!=-1) min2=min1;
            min1=root.val;
        }
        if (root.val>min1)
        {
            if (root.val<min2 || min2==-1)
            {
                min2=root.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null) return -1;
        dfs(root);
        return min2;
        /*if (root==null || root.left==null) return -1;
        int now=root.val;
        int l=root.left.val,r=root.right.val;
        if (l!=now && r!=now) return Math.min(l,r);
        if (l==now && r==now) 
        {
            int ll=findSecondMinimumValue(root.left),rr=findSecondMinimumValue(root.right);
            if (ll==-1 && rr==-1) return -1;
            if (ll!=-1 && rr!=-1) return Math.min(ll,rr);
            if (ll==-1) return rr;
            if (rr==-1) return ll;
        }
        if (l==now) return r;
        if (r==now) return l;
        return 0;*/
    }
}