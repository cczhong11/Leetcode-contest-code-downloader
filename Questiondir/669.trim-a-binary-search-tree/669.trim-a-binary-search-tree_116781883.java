	class Solution {
	    public TreeNode trimBST(TreeNode root, int L, int R) {
	    	return go(root, L, R);
	    }
	    
	    TreeNode go(TreeNode root, int L, int R)
	    {
	    	if(root == null)return null;
	    	if(L <= root.val && root.val <= R){
	    		root.left = go(root.left, L, R);
	    		root.right = go(root.right, L, R);
	    		return root;
	    	}else if(root.val < L){
	    		return go(root.right, L, R);
	    	}else{
	    		return go(root.left, L, R);
	    	}
	    }
	}	
