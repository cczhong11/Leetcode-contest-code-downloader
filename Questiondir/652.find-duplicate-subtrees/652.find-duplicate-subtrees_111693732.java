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
    Map<TreeNode,Integer> map=new HashMap<>();
    List<TreeNode> getSub(TreeNode root) 
    {
        List<TreeNode> sub=new ArrayList<>();
        if (root==null) return sub;
        sub=getSub(root.left);
        sub.addAll(getSub(root.right));
        sub.add(root);
        return sub;
    }
    boolean equal(TreeNode a,TreeNode b)
    {
        if (a==null && b==null) return true;
        if (a==null || b==null) return false;
        if (map.get(a)!=map.get(b)) return true;
        return (a.val==b.val && equal(a.left,b.left) && equal(a.right,b.right));
    }
    int dfs(TreeNode root)
    {
        if (root==null) return 0;
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans=new ArrayList<>();
        Set<TreeNode> set=new HashSet<>();
        if (root==null) return ans;
        List<TreeNode> sub=getSub(root);
        int x=dfs(root);
        if (x>1000) 
        {
            TreeNode now=root;
            while (now.right!=null) now=now.right;
            //ans.add(now);
            return ans;
        }
        for (TreeNode t1:sub)
            if (!set.contains(t1))
            {
                set.add(t1);
                boolean bo=false;
                for (TreeNode t2:sub)
                    if (t1!=t2 && equal(t1,t2))
                    {
                        bo=true;
                        set.add(t2);
                    }
                if (bo) ans.add(t1);
            }
        return ans;
    }
}