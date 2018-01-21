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
    HashMap<Integer, Long> maxMap;
    HashMap<Integer, Long> minMap;
    public int widthOfBinaryTree(TreeNode root) {
        maxMap = new HashMap<>();
        minMap = new HashMap<>();
        search(root, 0, 0);
        int res = 0;
        
        for (Integer depth: maxMap.keySet()){
            if (maxMap.get(depth) - minMap.get(depth) + 1 > res)
                res = (int)(maxMap.get(depth) - minMap.get(depth) + 1);
        }
        
        return res;
    }
    
    private void search(TreeNode cur, int depth, long idx){
        if (cur==null)
            return;
        
        if (!maxMap.containsKey(depth))
            maxMap.put(depth, idx);
        else if (maxMap.get(depth)<idx)
            maxMap.put(depth, idx);
        
        if (!minMap.containsKey(depth))
            minMap.put(depth, idx);
        else if (minMap.get(depth) > idx)
            minMap.put(depth, idx);
        
        search(cur.left, depth+1, idx*2);
        search(cur.right, depth+1, idx*2+1);
    }
}