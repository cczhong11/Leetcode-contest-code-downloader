	class Solution {
		List<Long> list = new ArrayList<>();
		
	    public boolean checkEqualTree(TreeNode root) {
	        long all = sum(root);
	        list.remove(list.size()-1);
	        if(all % 2 == 0){
	        	for(long v : list){
	        		if(v == all / 2){
	        			return true;
	        		}
	        	}
	        }
	        return false;
	    }
	    
	    long sum(TreeNode root)
	    {
	    	if(root == null)return 0;
	    	long ret = (long)root.val + sum(root.left) + sum(root.right);
	    	list.add(ret);
	    	return ret;
	    }
	}	
