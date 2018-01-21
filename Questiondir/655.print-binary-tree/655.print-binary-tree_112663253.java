import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
//	 static public class TreeNode {
//		     int val;
//		      TreeNode left;
//		      TreeNode right;
//		      TreeNode(int x) { val = x; }
//		  }
		 
    int rows, cols;
    
    int getColumn(TreeNode root, int d) {
        if (d >= rows) {
            rows = d;
        }
        if (root == null) return 0;
        int res = 1;
        int lc = getColumn(root.left, d + 1);
        int rc = getColumn(root.right, d + 1);
        res += Math.max(lc, rc) * 2;
        return res;
    }
    
    void doIt(TreeNode root, int d, String[][] store, int l, int r) {
    	if (root == null) return;
    	int mid = (l + r) / 2;
    	store[d][mid] = String.valueOf(root.val);
    	doIt(root.left, d + 1, store, l, mid);
    	doIt(root.right, d + 1, store, mid + 1, r);
    }
    
    public List<List<String>> printTree(TreeNode root) {
        rows = 0;
        cols = getColumn(root, 0);
        String[][] store = new String[rows][cols];
        for (int i = 0; i < rows; ++i) {
        	for (int j = 0; j < cols; ++j) {
        		store[i][j] = new String();
        	}
        }
        doIt(root, 0, store, 0, cols);
        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < store.length; ++i) {
        	List<String> delta = new LinkedList<String>();
        	for (int j = 0; j < store[i].length; ++j) {
        		delta.add(store[i][j]);
        	}
        	res.add(delta);
        }
        return res;
    }
}