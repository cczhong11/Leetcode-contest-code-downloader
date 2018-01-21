	  public class Solution {
		
		  Set<Long> set;
		  List<TreeNode> ret;
		  Set<Long> done;
		
	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	    	set = new HashSet<>();
	    	done = new HashSet<>();
	    	ret = new ArrayList<>();
	    	dfs(root);
	    	return ret;
	    }
	    
	    long[] dfs(TreeNode root)
	    {
	    	if(root == null)return new long[]{0L, 0};
	    	long[] hl = dfs(root.left);
	    	long[] hr = dfs(root.right);
	    	hl[0] += 31; hl[1]++;
	    	hr[0] += 31; hr[1]++;
	    	long h0 = root.val * 1000000009L + hl[0] * hl[0];
	    	h0 = h0 * 1000000009L + hr[0] * hr[0];
	    	long dh = Math.max(hl[1], hr[1]);
	    	long h = h0*1000000007L + dh;
	    	if(!set.add(h) && !done.contains(h)){
	    		ret.add(root);
	    		done.add(h);
	    	}
	    	return new long[]{h0, dh};
	    }
	}	
