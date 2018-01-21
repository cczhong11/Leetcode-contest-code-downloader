	public class Solution {
	    public List<List<String>> printTree(TreeNode root) {
	        int maxdep = go(root);
	        int n = maxdep;
	        int m = (1<<maxdep)-1;
	        List<List<String>> ret = new ArrayList<>();
	        for(int i = 0;i < n;i++){
	        	List<String> row = new ArrayList<>();
	        	for(int j = 0;j < m;j++){
	        		row.add("");
	        	}
	        	ret.add(row);
	        }
	        dfs(root, 0, m/2, m/2, ret);
	        
	        return ret;
	    }
	    
	    void dfs(TreeNode root, int r, int c, int w, List<List<String>> ret)
	    {
	    	if(root == null)return;
	    	ret.get(r).set(c, "" + root.val);
	    	dfs(root.left, r+1, c - w/2-1, w/2, ret);
	    	dfs(root.right, r+1, c + w/2+1, w/2, ret);
	    }
	    
	    int go(TreeNode root)
	    {
	    	if(root == null)return 0;
	    	
	    	return Math.max(go(root.left), go(root.right)) + 1;
	    }
	}	
