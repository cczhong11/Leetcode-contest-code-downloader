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
    Map<Integer,List<Integer>> m = new TreeMap<>();
    void f( TreeNode x, int d ) {
        if ( x == null )
            return ;
        if ( !m.containsKey(d) )
            m.put(d,new ArrayList<>());
        f(x.left,d+1);
        f(x.right,d+1);
        m.get(d).add(x.val);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        if ( root == null ) return new ArrayList<>();
        f(root,0);
        List<Double> res = new ArrayList<>();
        for ( Map.Entry<Integer,List<Integer>> entry: m.entrySet() ) {
            double a = 0;
            for ( Integer x: entry.getValue() )
                a += x;
            a /= entry.getValue().size();
            res.add(a);
        }
        return res;
    }
}