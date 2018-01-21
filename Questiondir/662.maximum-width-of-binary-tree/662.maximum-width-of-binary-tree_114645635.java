	class Solution {
		int mod = 1000000007;
		
	    public int widthOfBinaryTree(TreeNode root) {
	        int[] left = new int[500005];
	        int[] right = new int[500005];
	        Arrays.fill(left, -1);
	        dfs(root, 0, 0, left, right);
	        int max = 0;
	        for(int i = 0;i < left.length;i++){
	        	if(left[i] != -1){
	        		int cha = right[i] - left[i] + 1;
	        		if(cha < 0)cha += mod;
	        		max = Math.max(max, cha);
	        	}
	        }
	        return max;
	    }
	    
	    void dfs(TreeNode root, int dep, long ind, int[] left, int[] right)
	    {
	    	if(root == null)return;
	    	if(left[dep] == -1){
	    		left[dep] = (int)ind;
	    	}
	    	right[dep] = (int)ind;
	    	dfs(root.left, dep+1, ind*2%mod, left, right);
	    	dfs(root.right, dep+1, (ind*2+1)%mod, left, right);
	    }
	}
