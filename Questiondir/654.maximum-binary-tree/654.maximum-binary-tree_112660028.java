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
	TreeNode doIt(int[] nums, int l, int r) {
		if (l == r) return null;
		int p = -1;
		for (int i = l; i < r; ++i) {
			if (p == -1 || nums[i] > nums[p]) {
				p = i;
			}
		}
		TreeNode root = new TreeNode(nums[p]);
		root.left = doIt(nums, l, p);
		root.right = doIt(nums, p + 1, r);
		return root;
	}
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return doIt(nums, 0, nums.length);
    }
}