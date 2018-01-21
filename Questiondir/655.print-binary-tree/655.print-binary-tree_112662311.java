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
    int depth;
    public List<List<String>> printTree(TreeNode root) {
        depth = 0;
        getDepth(root, 1);
        List<List<String>> res = new ArrayList<>();
        for (int i=0;i<depth;i++){
            res.add(new ArrayList<>());
            for (int j=0;j<(1 << depth)-1;j++)
                res.get(i).add("");
        }
        
        fillArray(res, root ,0, 0, (1<<depth)-1);
        return res;
    }
    
    private void getDepth(TreeNode cur, int d){
        if (cur==null)
            return;
        
        depth = Math.max(depth, d);
        getDepth(cur.left, d+1);
        getDepth(cur.right, d+1);
    }
    
    private void fillArray(List<List<String>> res, TreeNode cur, int d, int lo, int hi){
        if (cur==null)
            return;
        int mid = (lo + hi)/2;
        res.get(d).set(mid, String.valueOf(cur.val));
        
        fillArray(res, cur.left, d+1, lo, mid);
        fillArray(res, cur.right, d+1, mid+1, hi);
    }
}