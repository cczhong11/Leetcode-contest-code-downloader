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
    class tuple{
        TreeNode t;
        char c;
        int i;
        boolean left;
        public tuple(TreeNode t){
            this.t = t;
            c = 0;
            i = 0;
            left = false;
        }
    }
    public TreeNode str2tree(String s) {
        Stack<tuple> s1 = new Stack<>();
        int i = 0, j = 0;
        if(s.length() == 0) return null;
        TreeNode root = null, current = null;;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c) || c == '-') {
                j = i + 1;
                while(j < s.length() && Character.isDigit(s.charAt(j))) j++;
                int val = Integer.parseInt(s.substring(i, j));
                TreeNode temp = new TreeNode(val);
                current = temp;
                if(s1.empty()) root = temp;
                else if(!s1.peek().left) {
                    s1.peek().t.left = temp;
                    s1.peek().left = true;}
                else s1.peek().t.right = temp;
                i = j;
                s1.push(new tuple(temp));
            }
            else if(c == '(') {
                s1.peek().i++;
                i++;
            }
            else if(c == ')') {
                while(s1.peek().i == 0) s1.pop();
                s1.peek().i--;
                i++;
            }
        }
        return root;
    }
}