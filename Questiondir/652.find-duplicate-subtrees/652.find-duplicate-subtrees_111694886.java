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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
        HashSet<TreeNode> result = new HashSet<TreeNode>();
        dfs(root, map, result);
        return new ArrayList<TreeNode>(result);
    }
    
    int dfs(TreeNode node, HashMap<Integer, List<TreeNode>> map, HashSet<TreeNode> result){
        if(node == null) return 0;
        //System.out.println("node" + node.val);
        int hashCode = (node.val * 31 + dfs(node.left, map, result)+1) * 31;
        //System.out.println("btw");
        hashCode += dfs(node.right, map, result)+1;
        //System.out.println("afterdfs");
        if(map.containsKey(hashCode)){
            List<TreeNode> previous = map.get(hashCode);
            boolean isSame = false;
            //System.out.println(previous == null);
            for(TreeNode p : previous){
                if(compare(p, node)){
                    result.add(p);
                    isSame = true;
                }
            }
                
                if(!isSame){
                    previous.add(node);
                }
        }else{
            List<TreeNode> current = new ArrayList<TreeNode>();
            current.add(node);
            map.put(hashCode, current);
        }
        
        return hashCode;
    }
    
    boolean compare(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null && node2 != null) return false;
        if(node1 != null && node2 == null) return false;
        if(node1.val != node2.val) return false;
        if(node1.val == node2.val){
            if(!compare(node1.left, node2.left)) return false;
            if(!compare(node1.right, node2.right)) return false;
        }
        return true;
    }
}