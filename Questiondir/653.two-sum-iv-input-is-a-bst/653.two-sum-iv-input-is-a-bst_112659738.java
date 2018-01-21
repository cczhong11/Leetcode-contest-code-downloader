	public class Solution {
	    public boolean findTarget(TreeNode root, int k) {
	    	List<Integer> list = new ArrayList<>();
	        dfs(root, list);
	        Collections.sort(list);
	        int p = list.size()-1;
	        for(int i = 0;i < list.size();i++){
	        	int v = k-list.get(i);
	        	while(p >= 0 && list.get(p) > v)p--;
	        	if(p >= 0 && p > i && list.get(p).intValue() == v)return true;
	        }
	        return false;
	    }
	    
	    void dfs(TreeNode root, List<Integer> list)
	    {
	    	if(root == null)return;
	    	if(root.left != null){
	    		dfs(root.left, list);
	    	}
	    	if(root.right != null){
	    		dfs(root.right, list);
	    	}
	    	list.add(root.val);
	    }
	}	
