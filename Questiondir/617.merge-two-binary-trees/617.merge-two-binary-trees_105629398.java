	 public class Solution {
	    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	        if(t1 == null && t2 == null)return null;
	        TreeNode ret = new TreeNode((t1 != null ? t1.val : 0) + 
        			(t2 != null ? t2.val : 0));
	        ret.left = mergeTrees(t1 != null ? t1.left : null, 
	        		t2 != null ? t2.left : null);
	        ret.right = mergeTrees(t1 != null ? t1.right : null, 
	        		t2 != null ? t2.right : null);
	        return ret;
	    }
	}	// 
