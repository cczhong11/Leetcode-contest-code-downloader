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
    public String get_next(char[] str , int idx){
		if(idx >= str.length) return "";
		StringBuilder sb = new StringBuilder();
		int left = 1;
		int right = 0;
		sb.append(str[idx]);
		idx ++;
		while(idx < str.length){
			if(str[idx] == '('){
				left ++;
			}
			if(str[idx] == ')'){
				right ++;
			}
			sb.append(str[idx]);
			idx ++;
			if(left == right)
				break;
		}
		return sb.toString();
	}

	public TreeNode str2tree(String s) {
		if(s.length() == 0) return null;
		char[] str = s.toCharArray();
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		while(idx < s.length()){
			if(str[idx] != '('){
				sb.append(str[idx ++]);
			}else{
				break;
			}
		}
		TreeNode root = new TreeNode(Integer.valueOf(sb.toString()));
		String ll = get_next(str , idx);
		String rr = get_next(str , idx + ll.length());
		if(ll.length() > 0)
			root.left = str2tree(ll.substring(1 , ll.length() - 1));
		if(rr.length() > 0)
			root.right = str2tree(rr.substring(1 , rr.length() - 1));
		return root;
	}
}