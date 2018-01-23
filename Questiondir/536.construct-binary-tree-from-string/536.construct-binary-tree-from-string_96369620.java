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
        if (s.startsWith("(")) s=s.substring(1, s.length()-1);
        if (s.length()==0) return null;
        int index=s.indexOf("(");
        if (index==-1) index=s.length();
        int v=Integer.parseInt(s.substring(0,index));
        TreeNode treeNode=new TreeNode(v);
        if (index==s.length()) return treeNode;
        int cnt=1, j=0;
        for (j=index+1;;j++) {
            if (s.charAt(j)=='(') cnt++;
            if (s.charAt(j)==')') cnt--;
            if (cnt==0) break;
        }
        treeNode.left=str2tree(s.substring(index, j+1));
        treeNode.right=str2tree(s.substring(j+1));
        return treeNode;
    }
}