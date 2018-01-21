import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
	Set<Integer> value;
	
	void doIt(TreeNode root) {
		if (root == null) return;
		value.add(root.val);
		doIt(root.left);
		doIt(root.right);
	}
    public int findSecondMinimumValue(TreeNode root) {
        value = new HashSet<>();
        doIt(root);
        if (value.size() >= 2) {
        	ArrayList<Integer> res = new ArrayList<>(value);
        	Collections.sort(res);
        	return res.get(1);
        }
        return -1;
    }
}