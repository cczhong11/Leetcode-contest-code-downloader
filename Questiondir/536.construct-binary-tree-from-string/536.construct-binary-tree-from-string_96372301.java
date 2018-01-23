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
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        } else {
            Stack<TreeNode> stack = new Stack<>();
            Map<TreeNode,Integer> map = new HashMap<>();
            
            for (int i=0; i<s.length(); ) {
                if (s.charAt(i) == '(') {
                    i++;
                } else if (s.charAt(i) == ')') {
                    TreeNode sub = stack.pop();
                    TreeNode parent = stack.peek();
                    
                    if (0 == map.get(parent)) {
                        parent.left = sub;
                        map.put(parent, 1);
                    } else {
                        parent.right = sub;
                        map.put(parent, 2);
                    }
                    i++;
                } else {
                    int j = i+1;
                    
                    while (j<s.length() && s.charAt(j)!='(' && s.charAt(j)!=')') {
                        j++;
                    }
                    TreeNode node = new TreeNode(Integer.parseInt(s.substring(i,j)));
                    
                    map.put(node, 0);
                    stack.push(node);
                    i = j;
                }
            }
            return stack.pop();
        }
    }
}